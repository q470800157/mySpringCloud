package com.springcloud.page;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "service-flower",fallback = FlowerPageImpl.class)
public interface FlowerPageService {

    @RequestMapping(value = "/flowers.do", method = RequestMethod.GET)
    String getAllFlower(@RequestParam(value = "name",required = false) String name);
}
