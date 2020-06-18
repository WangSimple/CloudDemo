package com.cloud.rbacserver.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.cloud.rbacapi.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<UserDto>{

    @Select("select #{str}")
    String selectByAnnotation(String str);

    List<UserDto> selectByXML(@Param(Constants.WRAPPER)QueryWrapper<UserDto> qw);

    String selecta();
}
