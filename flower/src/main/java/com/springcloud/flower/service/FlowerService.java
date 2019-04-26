package com.springcloud.flower.service;

import com.springcloud.flower.bean.Flower;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "service-flower")
public interface FlowerService {

//    @RequestMapping(value = "/getAllFlower.do",method = RequestMethod.GET)
    List<Flower> getAllFlower(String name);
}
