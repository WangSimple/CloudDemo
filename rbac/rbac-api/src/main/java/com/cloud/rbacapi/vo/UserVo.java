package com.cloud.rbacapi.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserVo {
    private String userId;
    private String userName;
    private String phone;
    private String address;
    private Integer age;
    private Timestamp createTime;
}
