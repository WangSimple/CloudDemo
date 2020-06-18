package com.cloud.rbacapi.dto;

import lombok.Data;

@Data
public class QueryCondition<T> {
    private int pageSize=10;
    private int pageNum=1;
    private String sortBy;
    private Boolean asc=true;
    private T data;
}
