package com.cloud.feign.service;

import com.cloud.feign.rpc.IUserRpc;
import com.cloud.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRpc userRpc;


    public String getUserInfo(User user){
       return userRpc.getUserInfo(user);
    }

}
