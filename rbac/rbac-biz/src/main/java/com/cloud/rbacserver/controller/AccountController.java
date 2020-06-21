package com.cloud.rbacserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "/account" ,tags = "账户接口")
@RequestMapping("/account")
public class AccountController {

    @PostMapping("/regist")
    @ApiOperation("注册账号")
    public ResponseEntity<String> registAccount(){
        return null;
    }
}
