package com.rent.carrentdal.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * order entity
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_order")
public class Order {

    @TableId
    private String id;
    private String orderCode;
    private String number;
    private Integer cId;
    private Integer carId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private BigDecimal deposit;
    private Integer status;

    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    private String lastModifiedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;



    private static final long serialVersionUID = 1L;
}
