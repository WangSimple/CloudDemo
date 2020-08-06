package org.simple.ribbon.consumer.controller;

import org.simple.ribbon.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class HelloController {
    @Autowired
    private HelloService service;

    @RequestMapping("/say")
    public String sayHello(String name){
        return service.sayHello(name);
    }
}
