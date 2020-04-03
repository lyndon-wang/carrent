package com.rent.carrentdal.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * customer entity
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_customer")
public class Customer {


    @TableId
    private String Id;
    private String Name;
    private String Credential;
    private Integer Age;
    private String CreatedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CreatedTime;
    private String LastModifiedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date LastTime;


    private static final long serialVersionUID = 1L;
}
