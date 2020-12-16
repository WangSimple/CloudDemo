package org.simple.demo.test.controller;

import org.simple.demo.test.springannotation.SpringAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private SpringAnnotation annotest;

    @GetMapping("/doa")
    public String doAsynchronezeMethod(){
        annotest.noAnnotation();
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "111";
    }
}
