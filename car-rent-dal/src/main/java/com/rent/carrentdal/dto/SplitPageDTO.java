package com.rent.carrentdal.dto;

import lombok.Data;

/**
 * @author lyndon
 * @version 2018/4/18/14:17
 */
@Data
public abstract class SplitPageDTO {

    private Integer page = 1;

    private Integer pageSize = 10;

    private Boolean asc = false;

}
