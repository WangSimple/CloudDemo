package org.simple.feign.rpc;

import org.simple.feign.conf.FeignClientsConfig;
import org.simple.feign.rpc.fallback.UserClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider",
        fallbackFactory = UserClientFallbackFactory.class,
        configuration = FeignClientsConfig.class
        )
public interface IExceptionRpc {


    @GetMapping("/provider/exception/user/{userId}")
    String getUserById(@PathVariable(value = "userId") String userId);
}
