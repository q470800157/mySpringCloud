package com.springcloud.pageribbon.service;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.pageribbon.bean.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "flowerError")
    public String allFlowers(String name){
        String json = restTemplate.getForObject("http://SERVICE-FLOWER/flowers.do?name="+name, String.class);
        return json;
    }

    public String flowerError(){
        Flower flower = new Flower();
        flower.setName("sorry,get flower error");
        List<Flower> list = new ArrayList<>();
        list.add(flower);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",list);
        String s = JSON.toJSONString(map);
        return s;
    }
}
