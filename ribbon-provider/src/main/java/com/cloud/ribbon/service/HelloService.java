package com.cloud.ribbon.service;

import com.cloud.ribbon.vo.User;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(String name){
        return "hello World! "+name;
    }


}
