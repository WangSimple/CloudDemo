package org.simple.feign.controller;

import org.simple.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class HelloController {

    @Autowired
    private HelloService service;
    @RequestMapping("/say")
    public String sayHello(@RequestParam("name") String name){
        return service.sayHello(name);
    }

    //public String getUser(){}
}
