package com.cloud.rbacserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.rbac.api.dto.QueryCondition;
import com.cloud.rbac.api.dto.UserDto;
import com.cloud.rbacserver.mapper.UserMapper;
import com.cloud.rbacserver.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Override
    public List<UserDto> searchUser(UserDto userDto) {
        List<UserDto> userDtoList = this.list(getUserQueryWrapper(userDto));
        return userDtoList;
    }

    @Override
    public IPage<UserDto> searchUserPage(QueryCondition<UserDto> condition) {
        IPage<UserDto> userDtoIPage = this.getBaseMapper().selectPage(condition.getPage(), getUserQueryWrapper(condition.getData()));
        return userDtoIPage;
    }

    @Transactional
    @Override
    public boolean saveUsers(List<UserDto> users) {
        return this.saveOrUpdateBatch(users);
    }


    private QueryWrapper<UserDto> getUserQueryWrapper(UserDto userDto){
        QueryWrapper<UserDto> wrapper=new QueryWrapper<UserDto>();
        wrapper.like(!StringUtils.isEmpty(userDto.getUserName()), "user_name", userDto.getUserName())
        .gt(userDto.getMinAge() != null, "age", userDto.getMinAge())
        .lt(userDto.getMaxAge() != null, "age", userDto.getMaxAge())
        .gt(userDto.getBeginCreatetime() != null, "createtime", userDto.getBeginCreatetime())
        .lt(userDto.getEndCreatetime() != null, "createtime", userDto.getEndCreatetime())
        .eq(userDto.getGender() != null, "gender", userDto.getGender());
        return wrapper;
    }
}
