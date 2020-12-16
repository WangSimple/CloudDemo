package org.simple.demo.test.springloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class SpringBeanB {
    @Autowired
    private SpringBeanC beanC;

    @PostConstruct
    public void initBean(){
        System.out.println(beanC);
    }

    public SpringBeanB(){
        System.out.println("SpringBeanB init " );
    }
}
