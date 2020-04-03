package com.rent.carrentdal.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rent.carrentdal.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order> {


}
