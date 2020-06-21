package com.cloud.rbac.api.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class QueryCondition<T> {
    private int pageSize=10;
    private int pageNum=1;
    private String desc;
    private String asc;
    private T data;

    public Page<T> getPage(){
        Page<T> page=new Page<T>();
        page.setAsc(asc);
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.setDesc(desc);
        return page;
    }
}
