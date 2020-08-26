package org.simple.feign.controller;

import org.simple.feign.service.UserService;
import org.simple.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public String getUser(@RequestBody User user){
        return userService.getUserInfo(user);
    }

    @GetMapping("/{userId}")
    public String getExceptionById(@PathVariable String userId){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<5;i++){
            sb.append( userService.getUserById(userId)+"\n");
        }
        System.out.println(123);
        return sb.toString();
    }
    @RequestMapping("/test")
    public String getUserById(){
        return "success";
    }
}
