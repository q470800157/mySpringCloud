package com.springcloud.cluster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisClusterService {

    Logger logger = LoggerFactory.getLogger(RedisClusterService.class);
    @Cacheable(value = "name")
    public String redisCluster(){
        logger.info("这个方法走了");
        return "bunny";
    }
}
