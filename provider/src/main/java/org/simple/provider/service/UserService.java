package org.simple.provider.service;

import org.simple.provider.vo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserInfo(User user){
        return user.toString();
    }

}

