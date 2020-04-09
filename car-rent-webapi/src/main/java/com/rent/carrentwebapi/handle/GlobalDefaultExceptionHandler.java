package com.rent.carrentwebapi.handle;


import com.rent.carrentcommon.bean.ResponseResult;
import com.rent.carrentcommon.constant.ResponseCode;
import com.rent.carrentcommon.exception.MyException;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * the global exception handler for controller layer
 */
@ControllerAdvice(basePackages = {"com.rent.carrentwebapi"})
@Log4j
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResponseResult requestExceptionHandler(MyException e) {
        log.error("myexception happen:{}", e);
        if (e.getE() != null) e.printStackTrace();
        return ResponseResult.builder().msg(e.getMsg()).state(e.getState()).build();
    }


    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseResult requestExceptionHandler(DataIntegrityViolationException e) {
        log.error("dataexception happen:{}", e);
        return ResponseResult.builder().msg("the data format exception").state(ResponseCode.FAILED.code).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("args not valid exception happen:{}", e);
        BindingResult result = e.getBindingResult();
        String s = "args valid failed";
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            s = errors.get(0).getDefaultMessage();
        }
        return ResponseResult.builder().state(ResponseCode.FAILED.code).msg(s).build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult requestExceptionHandler(Exception e) {
        log.error("unkonw exception happen:{}", e);
        e.printStackTrace();
        return ResponseResult.builder().msg("service exception").state(ResponseCode.FAILED.code).build();
    }


}
