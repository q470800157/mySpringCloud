package com.springcloud.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlowerPageImpl implements FlowerPageService {
    @Autowired
    private Flower flower;
    @Override
    public String getAllFlower() {
//        List<Flower> list = new ArrayList<>();
//        flower.setName("sorry,not get");
//        list.add(flower);
        return "sorry,error";
    }
}
