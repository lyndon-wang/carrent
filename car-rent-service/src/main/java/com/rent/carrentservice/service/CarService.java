package com.rent.carrentservice.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.rent.carrentdal.dto.CarDto;
import com.rent.carrentdal.entity.Car;


public interface CarService extends IService<Car> {

    /**
     * query the cars
     * @param carDto
     * @return
     * @throws Exception
     */
    Page<CarDto> queryList(CarDto carDto) throws Exception;
}
