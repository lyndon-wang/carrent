package com.rent.carrentcommon.bean;

import com.rent.carrentcommon.constant.ResponseCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * result bean
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "response body")
public class ResponseResult<T> implements Serializable {


    @ApiModelProperty(value = "the response code")
    private Integer state;

    @ApiModelProperty(value = "the data")
    private T data;

    @ApiModelProperty(value = "response message")
    private String msg;


    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum) {
        return e(statusEnum,null);
    }

    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum, T data) {
        ResponseResult<T> res = new ResponseResult<>();
        res.setState(statusEnum.code);
        res.setMsg(statusEnum.msg);
        res.setData(data);
        return res;
    }


    private static final long serialVersionUID = 8992436576262574064L;
}
