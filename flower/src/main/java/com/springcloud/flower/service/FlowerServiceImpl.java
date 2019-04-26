package com.springcloud.flower.service;

import com.springcloud.flower.bean.Flower;
import com.springcloud.flower.mapper.FlowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerMapper mapper;
    @Override
    public List<Flower> getAllFlower(String name) {
        List<Flower> flowers = mapper.getAllFlower(name);
        return flowers;
    }
}
