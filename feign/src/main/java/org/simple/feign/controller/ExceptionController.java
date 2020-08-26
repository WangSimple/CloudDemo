package org.simple.feign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.simple.feign.rpc.IExceptionRpc;
import org.simple.feign.rpc.exception.MyFeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @Autowired
    private IExceptionRpc exceptionRpc;

    @GetMapping("/{userId}")
    @HystrixCommand(fallbackMethod = "fallbackException")
    public String getExceptionById(@PathVariable String userId){
        try {
            String userById = exceptionRpc.getUserById(userId);
            System.out.println("-------------");
            return userById.toString();
        }catch (MyFeignException e) {
            return e.getResponse().status()+"---------"+e.getResponse().reason();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String fallbackException(String userId){
        return "this is fallback method "+userId;
    }

}
