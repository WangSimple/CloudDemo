package com.cloud.rbacserver.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.rbacapi.dto.QueryCondition;
import com.cloud.rbacapi.dto.UserDto;
import com.cloud.rbacserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    /**
     * @Description 根据ID查询
     * @param userId
     * @return java.lang.Object
     * @author xpWang
     * @date 2020/6/16 9:44
     */
    @GetMapping("/{userid}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userid") String userId){
        UserDto userDto = userService.getById(userId);
        if (userDto == null) {
            return new ResponseEntity<UserDto>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    /**
     * @Description 多条件查询接口
     * @return com.cloud.rbacserver.dto.UserDto
     * @author xpWang
     * @date 2020/6/16 11:21
     */
    @PostMapping("/query")
    public ResponseEntity<List<UserDto>> searchUser(@RequestBody UserDto userVo){
        log.info("searchUser : "+ JSON.toJSONString(userVo));
        List<UserDto> users = userService.searchUser(userVo);
        return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
    }

    /**
     * @Description 多条件分页查询接口
     * @return com.cloud.rbacserver.dto.UserDto
     * @author xpWang
     * @date 2020/6/16 11:21
     */
    @PostMapping("/page")
    public ResponseEntity<IPage<UserDto>> searchUserPages(@RequestBody QueryCondition<UserDto> condition){
        log.info("searchUser : "+ JSON.toJSONString(condition));
        IPage<UserDto> rst = userService.searchUserPage(condition);
        return new ResponseEntity<IPage<UserDto>>(rst,HttpStatus.OK);
    }

    /**
     * @Description 添加用户
     * @param userDto
     * @return java.lang.String
     * @author xpWang
     * @date 2020/6/16 9:46
     */
    @PostMapping("")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        log.info("add user");
        return new ResponseEntity<String>(userService.addUser(userDto),HttpStatus.OK);
    }

    /**
     * @Description 修改用户
     * @param userDto
     * @return java.lang.String
     * @author xpWang
     * @date 2020/6/16 9:46
     */
    @PutMapping("")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto){
        log.info("update user");
        return new ResponseEntity<String>(userService.updateUser(userDto),HttpStatus.OK);
    }
}
