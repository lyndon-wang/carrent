package com.rent.carrentdal.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rent.carrentdal.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface CarMapper extends BaseMapper<Car> {



}
