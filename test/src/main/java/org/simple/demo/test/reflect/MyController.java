package org.simple.demo.test.reflect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: xpwang
 * @date: 2020-12-16 4:01 下午
 */
@Controller
public class MyController {

    @Autowired
    private MyInterface myInterface;

    @RequestMapping("/a")
    public void myMethod(){
        myInterface.myMethod();
    }
}
