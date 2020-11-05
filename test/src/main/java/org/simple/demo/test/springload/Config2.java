package org.simple.demo.test.springload;

import org.simple.demo.test.springload.ConfigBean;
import org.simple.demo.test.springload.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@DependsOn("CartVo")
@Service
public class Config2 {
    @Autowired
    private UserVo userVo;

    @Bean
    public ConfigBean getConfig(){
        return new ConfigBean();
    }
    public Config2() {
        System.out.println("Config2 constructor");
    }

}
