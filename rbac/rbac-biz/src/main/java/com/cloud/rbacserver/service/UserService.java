package com.cloud.rbacserver.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.rbacapi.dto.QueryCondition;
import com.cloud.rbacapi.dto.UserDto;

import java.util.List;

public interface UserService extends IService<UserDto> {
    String addUser(UserDto userDto);
    String updateUser(UserDto userDto);
    List<UserDto> searchUser(UserDto userVo);
    Page<UserDto> searchUserPage(QueryCondition<UserDto> condition);
}
