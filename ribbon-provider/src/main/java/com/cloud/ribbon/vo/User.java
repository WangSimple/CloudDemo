package com.cloud.ribbon.vo;


import lombok.Data;

@Data
public class User {
    private String userName;
    private Integer userId;

    public String toString(){
        return userId+"---"+userName;
    }
}
