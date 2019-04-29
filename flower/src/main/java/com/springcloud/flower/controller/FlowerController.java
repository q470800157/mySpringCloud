package com.springcloud.flower.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.flower.bean.Flower;
import com.springcloud.flower.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FlowerController {
    @Autowired
    private FlowerService service;

    @RequestMapping("/getAllFlower.do")
    public ModelAndView getAllFlower(String name){
        ModelAndView mv = new ModelAndView("flowerList");
        List<Flower> flowers = service.getAllFlower(name);
        mv.addObject("list",flowers);
        return mv;
    }

    @RequestMapping("/flowers.do")
//    @ModelAttribute
    public String flowers(@RequestParam(value = "name",required = false) String name){
        List<Flower> flowers = service.getAllFlower(name);
        Map<String,Object> map = new HashMap<>();
        map.put("list",flowers);
        String jsonString = JSON.toJSONString(map);

        return jsonString;
    }
}
