package org.simple.demo.test.reflect;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: xpwang
 * @date: 2020-12-16 3:13 下午
 */
@Component
public class MyClass implements MyInterface{

    //@MyAnno
    @Override
    public void myMethod() {
        System.out.println(332);
    }


}
