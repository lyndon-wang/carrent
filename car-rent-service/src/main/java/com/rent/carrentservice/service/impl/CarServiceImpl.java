package com.rent.carrentservice.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.carrentdal.entity.Car;
import com.rent.carrentdal.mapper.CarMapper;
import com.rent.carrentservice.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lyndon
 * @version
 */
@Service
@Transactional
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
    @Override
    public List<Car> query() {
        return null;
    }
}

