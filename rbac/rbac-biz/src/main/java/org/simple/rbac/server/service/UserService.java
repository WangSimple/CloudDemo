package org.simple.rbac.server.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.simple.rbac.api.dto.QueryCondition;
import org.simple.rbac.api.dto.UserDto;

import java.util.List;

public interface UserService extends IService<UserDto> {
    String addUser(UserDto userDto);
    String updateUser(UserDto userDto);
    List<UserDto> searchUser(UserDto userVo);
    IPage<UserDto> searchUserPage(QueryCondition<UserDto> condition);
    boolean saveUsers(List<UserDto> users);
}
