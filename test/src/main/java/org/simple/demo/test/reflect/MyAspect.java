package org.simple.demo.test.reflect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: xpwang
 * @date: 2020-12-16 3:16 下午
 */
@Component
@Aspect
public class MyAspect {

    public MyAspect(){
        System.out.println("myaspect");
    }
    @Pointcut("@annotation(org.simple.demo.test.reflect.MyAnno)")
    void FutureApi(){
        System.out.println("mypointcut");
    }

    @Before("@annotation(org.simple.demo.test.reflect.MyAnno)")
    public void doBefore(JoinPoint joinPoint){
        Class clazz = joinPoint.getTarget().getClass();
        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;
        try {
            Method method = clazz.getMethod(msg.getName(), msg.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(123);
    }

}
