package com.cloud.feign.controller;

import com.cloud.feign.service.UserService;
import com.cloud.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/user/info")
    public String getUser(@RequestBody User user){
        return service.getUserInfo(user);
    }
}
