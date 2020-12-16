package org.simple.demo.test.springloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class SpringBeanA {

    @Autowired
    private SpringBeanB beanB;

    @PostConstruct
    public void initBean(){
        System.out.println(beanB);
    }

    public SpringBeanA(){
        System.out.println("SpringBeanA init " );
    }
}
