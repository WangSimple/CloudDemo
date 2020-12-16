package org.simple.demo.test.reflect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: xpwang
 * @date: 2020-12-16 4:14 下午
 */
@Component
public class MyInitClass {

    @Autowired
    private MyInterface myInterface;

    @PostConstruct
    public MyClass getMyClass(){
        myInterface.myMethod();
        return null;
    }
}
