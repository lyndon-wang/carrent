package com.rent.carrentdal.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * car entity
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_car")
public class Car implements Serializable {

    @TableId
    private String Id;
    private String Brand;
    private Integer Code;
    private String Model;
    private BigDecimal Price;
    private String CreatedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CreatedTime;
    private String LastModifiedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date LastTime;


    private static final long serialVersionUID = 1L;
}
