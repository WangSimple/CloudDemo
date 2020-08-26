package org.simple.provider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable String id) throws Exception {
        throw new RuntimeException("throw exception "+id);
        //Thread.sleep(1000);
        //return "1321";
    }


}
