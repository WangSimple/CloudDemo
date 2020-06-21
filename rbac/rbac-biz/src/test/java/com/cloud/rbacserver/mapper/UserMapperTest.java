package com.cloud.rbacserver.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.rbac.api.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {
    private UserDto condition;
    private QueryWrapper<UserDto> wrapper;
    private UserDto user;
    @BeforeEach
    public void init(){
        String str="{\n" +
                "    \"userId\": \"188df20401d43ed3c599570df8b0bc9c\",\n" +
                "    \"userName\": \"a1\",\n" +
                "    \"phone\": \"010-81818181\",\n" +
                "    \"address\": \"北京市昌平区XXXXX,XXXXXXX,XXXX\",\n" +
                "    \"age\": 14,\n" +
                "    \"gender\": false,\n" +
                "    \"createtime\": \"2020-06-15T09:52:10.000+0000\",\n" +
                "    \"updatetime\": \"2020-06-15T09:52:10.000+0000\"\n" +
                "}";
        user=JSON.parseObject(str,UserDto.class);
        str="{\n" +
                "    \"userName\": \"a\",\n" +
                "}";
        condition=JSON.parseObject(str,UserDto.class);
        wrapper=new QueryWrapper<UserDto>();
        wrapper.like(!StringUtils.isEmpty(condition.getUserName()), "user_name", condition.getUserName())
                .gt(condition.getMinAge() != null, "age", condition.getMinAge())
                .lt(condition.getMaxAge() != null, "age", condition.getMaxAge())
                .gt(condition.getBeginCreatetime() != null, "createtime", condition.getBeginCreatetime())
                .lt(condition.getEndCreatetime() != null, "createtime", condition.getEndCreatetime())
                .eq(condition.getGender() != null, "gender", condition.getGender());
        System.out.println(user);
        System.out.println(condition);
        System.out.println(wrapper.getCustomSqlSegment());
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void getList(){
        List<UserDto> userDtos = userMapper.selectList(null);
        System.out.println(userDtos);
    }
    @Test
    public void selectByAnnotation(){

        String str = userMapper.selectByAnnotation("str1");
        System.out.println(str);
    }

    @Test
    public void selectByXML(){
        List<UserDto> userDtos = userMapper.selectByXML(wrapper);
        System.out.println(userDtos);
    }

    @Test
    public void selecta(){
        String selecta = userMapper.selecta();
        System.out.println(selecta);
    }
}