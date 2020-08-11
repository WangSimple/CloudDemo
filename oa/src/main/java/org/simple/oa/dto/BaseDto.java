package org.simple.oa.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {
    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;
}

