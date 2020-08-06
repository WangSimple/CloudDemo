package org.simple.feign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ribbon-consumer")
public interface GetHello {

    @RequestMapping("/consumer/say")
    String sayHello(@RequestParam("name") String name);


}
