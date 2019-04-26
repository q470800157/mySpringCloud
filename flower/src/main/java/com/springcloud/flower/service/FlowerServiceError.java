package com.springcloud.flower.service;

import com.springcloud.flower.bean.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//@Component
public class FlowerServiceError implements FlowerService {
    @Autowired
    private Flower flower;
    @Override
    public List<Flower> getAllFlower(String name) {
        flower.setId(0);
        flower.setName("no data");
        flower.setPrice(0.00);
        flower.setPid(0);
        List<Flower> list = new ArrayList<>();
        list.add(flower);
        return list;
    }
}
