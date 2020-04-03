package com.rent.carrentcommon.exception;

import com.rent.carrentcommon.constant.ResponseCode;
import lombok.*;

import java.io.Serializable;

/**
 * define exception
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException implements Serializable {
    private Integer state;
    private String msg;
    private Exception e;

    public MyException(ResponseCode statusEnum, Exception e) {
        this.state = statusEnum.code;
        this.msg = statusEnum.msg;
        this.e = e;

    }

    public MyException(ResponseCode statusEnum) {
        this.state = statusEnum.code;
        this.msg = statusEnum.msg;

    }

    public synchronized static MyException fail(String msg) {
        return MyException.builder()
                .state(ResponseCode.FAILED.code)
                .msg(msg)
                .build();
    }

    public synchronized static MyException fail(String msg, Exception e) {
        return MyException.builder()
                .state(ResponseCode.FAILED.code)
                .msg(msg)
                .e(e)
                .build();
    }

    public synchronized static MyException fail(Integer code, String msg, Exception e) {
        return MyException.builder()
                .state(code)
                .msg(msg)
                .e(e)
                .build();
    }


}
