package com.springcloud.flower.mapper;

import com.springcloud.flower.bean.Flower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FlowerMapper {

    List<Flower> getAllFlower(@Param("name") String name);
}
