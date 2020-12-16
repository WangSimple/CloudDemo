package org.simple.demo.test.springannotation;

import org.simple.demo.test.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("SpringAnnotation")
public class SpringAnnotation {
    @Autowired
    //private Annotation2 a;

    @PostConstruct
    public void initMethod() {
        //noAnnotation();
    }

    @Async
    public void noAnnotation() {
        System.out.println(Thread.currentThread().getName() + " : 这是一个没有注解的方法");
        SpringAnnotation proxyBean= ApplicationContextUtil.getBean(this.getClass().getSimpleName());
        proxyBean.hasAnnotation();
        System.out.println("noAnnotation结束");
    }

    @Async
    public void hasAnnotation(){
        System.out.println(Thread.currentThread().getName()+" : 进入方法hasAnnotation，先睡5秒");
        try {
            Thread.sleep(5*1000);
            System.out.println(Thread.currentThread().getName()+" : 睡醒了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


