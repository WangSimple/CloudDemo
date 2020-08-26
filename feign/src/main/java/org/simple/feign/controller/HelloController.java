package org.simple.feign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.simple.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private HelloService service;
    @RequestMapping("/say")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String sayHello(@RequestParam("name") String name) throws Exception {
        throw new Exception("rpc exception");
        //return service.sayHello(name);
    }

    //public String getUser(){}
    public String helloFallback(String name){
        return "fallback"+name;
    }
}
