package com.springcloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.zuul.redis.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
@RefreshScope
public class MyFilter extends ZuulFilter {
    @Value("${token}")
    private String token;
    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    Logger logger = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        String token1 = (String) ops.get("token1");
        if ("".equals(token1) || null == token1) {
            token1 = request.getParameter("token");
        }
        if ("".equals(token1) || token1 == null || !token.equals(token1)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(405);
            if (!"".equals(token1) && null != token1 ){
                redisTemplate.delete("token1");
            }
            try {
                currentContext.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        ops.set("token1",token1,60, TimeUnit.SECONDS);
        logger.info("token值为"+token);
        return null;
    }
}
