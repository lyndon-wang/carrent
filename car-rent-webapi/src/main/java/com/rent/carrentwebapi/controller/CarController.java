package com.rent.carrentwebapi.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.rent.carrentcommon.bean.ResponseResult;
import com.rent.carrentcommon.constant.ResponseCode;
import com.rent.carrentcommon.exception.MyException;
import com.rent.carrentdal.dto.CarDto;
import com.rent.carrentservice.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/car"})
@Api(tags ={"car controller"})
@Slf4j
public class CarController {

    @Autowired
    private CarService carService;


    @RequestMapping(value={"/test"},method= RequestMethod.GET)
    @ApiOperation(value="test", notes="test controller")
    public String test(){
        return "ok";
    }


    @RequestMapping(value={"/v1/getCarsList"},method= RequestMethod.POST)
    @ApiOperation(value="query", notes="query car controller")
    public ResponseResult queryList(@RequestBody @Validated @ApiParam(value = "access parameter bean") CarDto carDto){
        Page<CarDto> datas = null;
        try {
            datas = carService.queryList(carDto);
        } catch (MyException e) {
            log.error("CarController|queryList|MyException e:{}", e);
            return ResponseResult.e(ResponseCode.SERVICE_EXCEPTION, null);
        } catch (Exception e) {
            log.error("CarController|queryList|Exception e:{}", e);
            return ResponseResult.e(ResponseCode.UNKONW_EXCEPTION, e);
        }

        return ResponseResult.e(ResponseCode.OK, datas);
    }


}
