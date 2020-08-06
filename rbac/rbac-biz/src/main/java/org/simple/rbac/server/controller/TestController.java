package org.simple.rbac.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "连通性测试")
@RestController
@Slf4j
class TestController {
    @RequestMapping("/test")
    @ApiOperation("调通测试")
    public ResponseEntity<String> registAccount(){
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>test");
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}