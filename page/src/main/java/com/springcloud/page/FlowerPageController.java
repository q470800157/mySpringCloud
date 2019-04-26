package com.springcloud.page;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class FlowerPageController {
    @Autowired
    private FlowerPageService service;

    @RequestMapping("/toFlower.do")
    public ModelAndView toFlowerList(){
        ModelAndView mv= new ModelAndView("flowerList");
        return mv;
    }
    @RequestMapping("/flowers.do")
    public ModelAndView allFlowers(){
        ModelAndView mv= new ModelAndView("flowerList");
        String json = service.getAllFlower();
        Map<String,Object> map = (Map<String,Object>) JSON.parse(json);
        List<Flower> flowers = (List<Flower>)map.get("list");
        mv.addObject("list",flowers);
        return mv;
    }
}
