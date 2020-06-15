package com.cloud.rbacserver.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.rbacserver.dto.UserDto;

public interface UserService extends IService<UserDto> {
    String addUser(UserDto userDto);
    String updateUser(UserDto userDto);
}
