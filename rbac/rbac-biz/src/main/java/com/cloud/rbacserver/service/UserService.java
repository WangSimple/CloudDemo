package com.cloud.rbacserver.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.rbac.api.dto.QueryCondition;
import com.cloud.rbac.api.dto.UserDto;

import java.util.List;

public interface UserService extends IService<UserDto> {
    String addUser(UserDto userDto);
    String updateUser(UserDto userDto);
    List<UserDto> searchUser(UserDto userVo);
    IPage<UserDto> searchUserPage(QueryCondition<UserDto> condition);
    boolean saveUsers(List<UserDto> users);
}
