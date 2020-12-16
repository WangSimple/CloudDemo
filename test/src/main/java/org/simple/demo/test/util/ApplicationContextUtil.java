package org.simple.demo.test.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationContextUtil  implements ApplicationContextAware {
    private static ApplicationContext applicationContext;



    public static <T> T getBean(String beanName){
        return (T) applicationContext.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext a) throws BeansException {
        applicationContext=a;
    }
}
