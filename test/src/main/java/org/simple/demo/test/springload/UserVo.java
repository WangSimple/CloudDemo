package org.simple.demo.test.springload;

import lombok.Data;
import org.springframework.stereotype.Component;

//@Component
@Data
public class UserVo {
    private  Integer userID;
    private String userName;

    public UserVo(){
        System.out.println("uservo constructor");
    }
}
