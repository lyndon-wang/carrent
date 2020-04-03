package com.rent.carrentservice.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.rent.carrentcommon.constant.Constants;
import com.rent.carrentcommon.exception.MyException;
import com.rent.carrentdal.dto.OrderDto;
import com.rent.carrentdal.entity.Order;
import com.rent.carrentdal.mapper.OrderMapper;
import com.rent.carrentservice.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author lyndon
 */
@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Page<OrderDto> queryOrders(OrderDto orderDto) throws Exception {
        EntityWrapper<Order> wrapper = new EntityWrapper<>();

        if (StringUtils.isNotEmpty(orderDto.getOrderCode())) {
            wrapper.eq("OrderCode", orderDto.getOrderCode());
        }
        if (orderDto.getDeposit() != null) {
            wrapper.eq("Deposit", orderDto.getDeposit());
        }
        if (orderDto.getBeginTime() != null) {
            wrapper.gt("CreatedTime", orderDto.getBeginTime());
        }
        if (orderDto.getEndTime() != null) {
            wrapper.le("EndTime", orderDto.getEndTime());
        }

        wrapper.orderBy("CreatedTime", orderDto.getAsc());
        Page<Order> orderPage = this.selectPage(new Page<>(orderDto.getPage(), orderDto.getPageSize()), wrapper);
        Page<OrderDto> orderDtoPage = new Page<>();
        BeanUtils.copyProperties(orderPage, orderDtoPage);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<OrderDto> voList = new ArrayList<>();

        orderPage.getRecords().forEach(v -> {
                    OrderDto vo = new OrderDto();
                    BeanUtils.copyProperties(v, vo);
                    vo.setBeginTime(sf.format(v.getBeginTime()));
                    vo.setEndTime(sf.format(v.getEndTime()));
                    voList.add(vo);
                }

        );

        orderDtoPage.setRecords(voList);

        return orderDtoPage;
    }

    @Override
    public boolean add(OrderDto orderDto) throws Exception {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);

        Date date = new Date();
        order.setCreatedTime(date);
        order.setLastTime(date);
        order.setStatus(Constants.EFFECTIVE);

        return this.insert(order);
    }

    @Override
    public boolean update(OrderDto orderDto) throws Exception {
        Order order = this.selectById(orderDto.getId());

        if (order == null) {
            throw MyException.fail("update failed,the id=" + orderDto.getId() + " not exist.");
        }
        BeanUtils.copyProperties(orderDto, order);
        order.setLastTime(new Date());
        order.setLastModifiedBy(orderDto.getName());

        return this.updateById(order);
    }

    @Override
    public boolean delete(Integer id) {
        Order order=this.selectOne(new EntityWrapper<Order>().eq("id",id).setSqlSelect("id"));
        if(order==null){
            throw MyException.fail("delete failed,the id" + id + "not exist.");
        }
        order.setStatus(Constants.DELETE);

        return this.updateById(order);
    }

    @Override
    public OrderDto getOrderById(Integer id) throws Exception {
        Order order = this.selectById(id);
        OrderDto orderDto=new OrderDto();

        if (order == null) {
            return null;
        }
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }
}

