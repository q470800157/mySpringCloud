package com.springcloud.page;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "service-flower",fallback = FlowerPageImpl.class)
public interface FlowerPageService {

    @RequestMapping(value = "/flowers.do",method = RequestMethod.GET)
    String getAllFlower();
}
