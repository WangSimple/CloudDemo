package org.simple.demo.test.springload;

import org.simple.demo.test.springload.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Config3 {

    @Autowired
    private CartVo userVo;

    public Config3() {
        System.out.println("Config3 constructor");
    }

}
