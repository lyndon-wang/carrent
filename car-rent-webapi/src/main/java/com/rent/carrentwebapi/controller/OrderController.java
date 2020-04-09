package com.rent.carrentwebapi.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.rent.carrentcommon.bean.ResponseResult;
import com.rent.carrentcommon.constant.ResponseCode;
import com.rent.carrentdal.dto.OrderDto;
import com.rent.carrentservice.service.OrderService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/order"})
@Api(tags = {"order controller"})
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = {"v1/getOrderList"}, method = RequestMethod.POST)
    @ApiOperation(value = "query the order list", notes = "according to ordercode,deposit")
    public ResponseResult list(@RequestBody @Validated @ApiParam(value = "access parameter bean") OrderDto orderDto) throws Exception {

        Page<OrderDto> datas = orderService.queryOrders(orderDto);

        return ResponseResult.e(ResponseCode.OK, datas);
    }

    @PostMapping(value = {"v1/getOrder/{id}"})
    @ApiOperation(value = "find order by id")
    public ResponseResult getOrder(@PathVariable("id") @ApiParam(value = "order id") Integer id) {
        return ResponseResult.e(ResponseCode.OK, orderService.selectById(id));
    }

    @PostMapping(value = {"v1/deleteOrder/{id}"})
    @ApiOperation(value = "delete order by id")
    public ResponseResult remove(@PathVariable("id") @ApiParam(value = "order id") Integer id) throws Exception {
        boolean rt = orderService.delete(id);
        if (rt == false) {
            return ResponseResult.e(ResponseCode.FAILED, null);
        }
        return ResponseResult.e(ResponseCode.OK, null);
    }

    @PostMapping(value = {"v1/bookcar"})
    @ApiOperation(value = "add order")
    public ResponseResult add(@RequestBody @Validated @ApiParam(value = "add bean") OrderDto orderDto) throws Exception {

        boolean rt = orderService.add(orderDto);
        if (rt == false) {
            return ResponseResult.e(ResponseCode.FAILED, null);
        }
        return ResponseResult.e(ResponseCode.OK, null);
    }


    @PostMapping(value = {"v1/updateOrder"})
    @ApiOperation(value = "update order")
    public ResponseResult update(@RequestBody @Validated @ApiParam(value = "update bean") OrderDto orderDto) throws Exception {

        boolean rt = orderService.update(orderDto);
        if (rt == false) {
            return ResponseResult.e(ResponseCode.FAILED, null);
        }
        return ResponseResult.e(ResponseCode.OK, null);
    }

}
