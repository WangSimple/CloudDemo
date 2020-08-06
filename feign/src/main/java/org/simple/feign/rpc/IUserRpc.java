package org.simple.feign.rpc;

import org.simple.feign.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("ribbon-provider")
public interface IUserRpc {

    @RequestMapping("/provider/user/info")
    String getUserInfo(@RequestBody User user);

}