package org.simple.feign.rpc.fallback;

import org.simple.feign.rpc.IUserRpc;
import org.simple.feign.vo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements IUserRpc {
    @Override
    public String getUserInfo(User user) {
        return "falback ";
    }

    @Override
    public String getUserById(String userId) {
        return "falback ";
    }
}
