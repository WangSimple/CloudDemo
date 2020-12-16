package org.simple.demo.test.springload;

import org.simple.demo.test.springload.CartVo;
import org.simple.demo.test.springload.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

//@Configuration
public class SpringloadTest {

    @Autowired
    private UserVo userVo;

//    @Autowired
//    private CartVo c;

    public SpringloadTest(){
        System.out.println("SpringloadTest constructor");
    }

    //@Bean(name="CartVo")
    public CartVo getCartVo(){
        System.out.println("getCartVo");
        return new CartVo();
    }

    @PostConstruct
    public void init()
    {
        System.out.println("postconstruct");

    }
}
