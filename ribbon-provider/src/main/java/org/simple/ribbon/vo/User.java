package org.simple.ribbon.vo;


import lombok.Data;

@Data
public class User {
    private String userName;
    private Integer userId;

    public static void main(String[] args) {

    }

    public String toString(){
        return userId+"---"+userName;
    }
}
