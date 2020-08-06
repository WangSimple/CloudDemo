package org.simple.feign.service;

import org.simple.feign.rpc.IUserRpc;
import org.simple.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringValueResolver;

@Service
public class UserService {
    @Autowired
    private IUserRpc userRpc;


    public String getUserInfo(User user){
        StringValueResolver sr=null;
        return userRpc.getUserInfo(user);
    }

}
