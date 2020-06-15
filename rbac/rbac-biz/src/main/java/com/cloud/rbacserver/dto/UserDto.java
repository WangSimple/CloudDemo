package com.cloud.rbacserver.dto;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("userinfo")
public class UserDto {
    @TableId(value = "user_id",type = IdType.UUID)
    private String userId;
    @TableField("user_name")
    private String userName;
    private String phone;
    private String address;
    private Integer age;
    private Boolean gender;
    private Timestamp createtime;
    private Timestamp updatetime;

    public static void main(String[] args) {
        UserDto userDto=new UserDto();
        userDto.setAddress("北京市昌平区XXXXX,XXXXXXX,XXXX");
        userDto.setAge(12);
        userDto.setGender(true);
        userDto.setPhone("010-81818181");
        userDto.setUserName("张三");
        String str = JSON.toJSONString(userDto);
        System.out.println(str);
    }
}
