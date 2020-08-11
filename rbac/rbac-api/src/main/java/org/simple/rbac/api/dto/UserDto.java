package org.simple.rbac.api.dto;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_userinfo")
public class UserDto extends BaseDto{
    @TableId(value = "user_id",type = IdType.UUID)
    private String userId;
    @TableField("user_name")
    private String userName;
    private String phone;
    private String address;
    private Integer age;
    @TableField(exist = false)
    private Integer maxAge;
    @TableField(exist = false)
    private Integer minAge;
    private Boolean gender;
    @TableField(exist = false)
    private Timestamp beginCreatetime;
    @TableField(exist = false)
    private Timestamp endCreatetime;

    @JsonIgnore
    public Timestamp getBeginCreatetime() {
        return beginCreatetime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public void setBeginCreatetime(Timestamp beginCreatetime) {
        this.beginCreatetime = beginCreatetime;
    }
    @JsonIgnore
    public Timestamp getEndCreatetime() {
        return endCreatetime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public void setEndCreatetime(Timestamp endCreatetime) {
        this.endCreatetime = endCreatetime;
    }

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
    public static UserDto getAdimn(){
        UserDto userDto=new UserDto();
        userDto.setUserId("-1");
        userDto.setAddress("XXXXX,XXXXXXX,XXXX");
        userDto.setAge(0);
        userDto.setGender(true);
        userDto.setPhone("010-000000");
        userDto.setUserName("管理员");
        return userDto;
    }
}
