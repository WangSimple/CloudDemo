package org.simple.demo.test.springannotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Annotation2 {
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
