package org.simple.ribbon.service;

import org.simple.ribbon.vo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserInfo(User user){
        return user.toString();
    }

}

