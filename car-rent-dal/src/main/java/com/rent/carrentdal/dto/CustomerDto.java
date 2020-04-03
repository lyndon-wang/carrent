package com.rent.carrentdal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDto extends SplitPageDTO {

    private String id;

    private String name;

    private String credential;

    private Integer age;

    private String createdBy;

    private Date createdTime;

    private String lastModifiedBy;

    private Date lastTime;
}
