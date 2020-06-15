package com.cloud.rbacserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.rbacserver.dto.UserDto;
import com.cloud.rbacserver.mapper.UserMapper;
import com.cloud.rbacserver.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserDto> implements UserService{

    @Override
    public String addUser(UserDto userDto) {
        boolean rst = this.save(userDto);
        return userDto.getUserId();
    }

    @Override
    public String updateUser(UserDto userDto) {
        this.updateById(userDto);
        return userDto.getUserId();
    }
}
