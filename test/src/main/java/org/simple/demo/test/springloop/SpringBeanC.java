package org.simple.demo.test.springloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class SpringBeanC {

    @Autowired
    private SpringBeanA beanA;

    @PostConstruct
    public void initBean(){
        System.out.println(beanA);
    }

    public SpringBeanC(){
        System.out.println("SpringBeanC init " );
    }
}
