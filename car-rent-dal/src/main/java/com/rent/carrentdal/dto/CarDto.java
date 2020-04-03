package com.rent.carrentdal.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CarDto extends SplitPageDTO {

    private Integer id;

    private String brand;

    private Integer code;

    private String model;

    private BigDecimal price;

    private String createdBy;

    private Date createdTime;

    private String lastModifiedBy;

    private Date lastTime;

}
