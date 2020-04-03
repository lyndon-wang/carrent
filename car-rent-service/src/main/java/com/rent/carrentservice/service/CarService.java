package com.rent.carrentservice.service;

import com.baomidou.mybatisplus.service.IService;
import com.rent.carrentdal.entity.Car;

import java.util.List;

public interface CarService extends IService<Car> {

     List<Car> query();
}
