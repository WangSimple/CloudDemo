package org.simple.feign.rpc.fallback;

import feign.hystrix.FallbackFactory;
import org.simple.feign.rpc.IUserRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallbackFactory implements FallbackFactory<IUserRpc> {
    @Autowired
    private UserClientFallback userClientFallback;


    @Override
    public IUserRpc create(Throwable throwable) {
        throwable.printStackTrace();
        return userClientFallback;
    }
}
