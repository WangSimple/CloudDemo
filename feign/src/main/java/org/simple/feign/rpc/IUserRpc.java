package org.simple.feign.rpc;

import org.simple.feign.rpc.fallback.UserClientFallbackFactory;
import org.simple.feign.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider",
        fallbackFactory = UserClientFallbackFactory.class
        )
public interface IUserRpc {

    @RequestMapping("/provider/user/info")
    String getUserInfo(@RequestBody User user);

    @GetMapping("/provider/user/{userId}")
    String getUserById(@PathVariable(value = "userId") String userId);
}
