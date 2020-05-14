package com.cloud.ribbon.service;

import com.cloud.ribbon.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserInfo(User user){
        return user.toString();
    }

}
