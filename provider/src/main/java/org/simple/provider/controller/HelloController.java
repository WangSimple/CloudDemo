package org.simple.provider.controller;

import org.simple.provider.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private HelloService service;
    @RequestMapping("/say")
    public String sayHello(@RequestParam String name, HttpServletRequest request){
        System.out.println(request.getLocalAddr()+"-----"+request.getLocalPort());
        return request.getLocalAddr()+"-----"+request.getLocalPort()+"-----"+service.sayHello(name);
    }


}
