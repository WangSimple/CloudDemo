package com.cloud.rbacserver.mapper;

import com.cloud.rbacapi.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getList(){
        List<UserDto> userDtos = userMapper.selectList(null);
        System.out.println(userDtos);
    }
}