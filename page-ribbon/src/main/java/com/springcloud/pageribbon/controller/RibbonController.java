package com.springcloud.pageribbon.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.pageribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RibbonController {
    @Autowired
    private RibbonService service;

    @RequestMapping("/toFlower.do")
    public ModelAndView toFlowerList(){
        ModelAndView mv = new ModelAndView("flowerList");
        return mv;
    }
    @RequestMapping("/flowers.do")
    public ModelAndView getAllFlower(String name){
        ModelAndView mv = new ModelAndView("flowerList");
        List flowers = new ArrayList();
        String jsonstr = service.allFlowers(name);
        Map map = (Map)JSON.parse(jsonstr);
        flowers = (List) map.get("list");
        mv.addObject("list",flowers);
        mv.addObject("name",name);
        return mv;
    }
    @RequestMapping("/addFlower.do")
    public ModelAndView toAddFlower(){
        ModelAndView mv = new ModelAndView("addFlower");
        return mv;
    }
}
