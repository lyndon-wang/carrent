package com.rent.carrentcommon.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyndon
 * @version 2018/4/18/10:54
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {

    OK(0,"sucess"),
    FAILED(1,"request fail"),
    PARAMETER_EMPTY(3900001,"some request parameter cannot be empty."),
    PARAMETER_TYPE_ERROR(3900002,"some request parameter type is error."),
    SERVICE_EXCEPTION(3900003,"service exception."),
    TIME_OUT(3900004,"connect timeout."),
    NOT_FOUND(3900005,"data not found."),
    FORBIDDEN(3900006,"not allow to access."),
    UNKONW_EXCEPTION(3900007,"unknow exception");

    public Integer code;

    public String msg;

    public static List<ResponseMessage> getArrayMessage(){
        ArrayList<ResponseMessage> responseMessages = new ArrayList<>();
        for (ResponseCode statusEnum : ResponseCode.values()) {
            responseMessages.add(new ResponseMessageBuilder()
                    .code(statusEnum.code)
                    .message(statusEnum.msg)
                    .build());
        }
        return responseMessages;
    }

}
