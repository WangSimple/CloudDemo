package org.simple.provider.controller;

import org.simple.provider.service.UserService;
import org.simple.provider.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/info")
    public String getUser(@RequestBody User user){

        return service.getUserInfo(user);
    }

    @RequestMapping("/{id}")
    public String getUser(@PathVariable String id){
        return id;
    }
}
