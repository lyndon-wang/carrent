package com.rent.carrentservice.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.rent.carrentdal.dto.CarDto;
import com.rent.carrentdal.dto.OrderDto;
import com.rent.carrentdal.entity.Car;
import com.rent.carrentdal.mapper.CarMapper;
import com.rent.carrentservice.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lyndon
 */
@Service
@Transactional
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

    @Override
    public Page<CarDto> queryList(CarDto carDto) throws Exception {

        EntityWrapper<Car> wrapper = new EntityWrapper<>();

        if (StringUtils.isNotEmpty(carDto.getBrand())) {
            wrapper.eq("brand", carDto.getBrand());
        }
        if (StringUtils.isNotEmpty(carDto.getModel())) {
            wrapper.eq("model", carDto.getModel());
        }

        wrapper.orderBy("CreatedTime", carDto.getAsc());
        Page<Car> carPage = this.selectPage(new Page<>(carDto.getPage(), carDto.getPageSize()), wrapper);
        Page<CarDto> carDtoPage = new Page<>();
        BeanUtils.copyProperties(carPage, carDtoPage);

        List<CarDto> voList = new ArrayList<>();
        carPage.getRecords().forEach(v -> {
                    CarDto vo = new CarDto();
                    BeanUtils.copyProperties(v, vo);
                    voList.add(vo);
                }

        );

        carDtoPage.setRecords(voList);

        return carDtoPage;
    }
}

