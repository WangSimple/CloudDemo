package com.cloud.rbacserver.controller;

import com.cloud.rbacserver.dto.UserDto;
import com.cloud.rbacserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userid}")
    public UserDto getUser(@PathVariable("userid") String userId){
        return userService.getById(userId);
    }

    @GetMapping("")
    public void searchUser(){
    }

    @PostMapping("")
    public String saveUser(@RequestBody UserDto userDto){

        if (StringUtils.isEmpty(userDto.getUserId())){
            log.info("add user");
            return userService.addUser(userDto);
        }else{
            log.info("update user");
            return userService.updateUser(userDto);
        }

    }
}
