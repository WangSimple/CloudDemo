package com.cloud.feign.service;

import com.cloud.feign.rpc.GetHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    GetHello getHello;
    public String sayHello(String name){
        StringBuilder sb=new StringBuilder("");
        for (int i=0;i<10;i++){
            sb.append(getHello.sayHello(name)).append("\n");
        }
        return sb.toString();
    }
}
