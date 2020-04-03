package com.rent.carrentdal.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto extends SplitPageDTO {

    private String id;

    private String orderCode;

    private String number;

    private Integer cId;

    private Integer carId;

    private String beginTime;

    private String endTime;

    private BigDecimal deposit;

    private String createdBy;

    private String createdTime;

    private String lastModifiedBy;

    private String lastTime;

    private String name;


}
