package com.rent.carrentservice.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.rent.carrentdal.dto.OrderDto;
import com.rent.carrentdal.entity.Order;


public interface OrderService extends IService<Order> {

    /**
     * query for order
     * @param orderDto
     * @return
     */
    Page<OrderDto> queryOrders(OrderDto orderDto) throws Exception;

    /**
     * add order
     * @param orderDto
     * @return
     */
    boolean add(OrderDto orderDto) throws Exception;

    /**
     * update order
     * @param orderDto
     * @return
     * @throws Exception
     */
    boolean update(OrderDto orderDto) throws Exception;

    /**
     * delete order
     * @param id
     * @return
     */
    boolean delete(Integer id) throws Exception;


    /**
     * find order by id
     * @param id
     * @return
     * @throws Exception
     */
    OrderDto getOrderById(Integer id) throws Exception;



}
