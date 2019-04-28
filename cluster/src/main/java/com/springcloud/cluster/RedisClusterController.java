package com.springcloud.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisClusterController {

    @Autowired
    private RedisClusterService service;

    @RequestMapping("/rediscluster.do")
    public String testCluster(){
        String name = "";
        name = service.redisCluster();
        return name;
    }
}
