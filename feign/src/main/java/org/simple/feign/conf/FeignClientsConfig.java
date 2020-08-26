package org.simple.feign.conf;

import feign.codec.ErrorDecoder;
import org.simple.feign.rpc.fallback.MyErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientsConfig {

    @Bean
    public ErrorDecoder errorDecoder(){
        return new MyErrorDecoder();
    }

    //在配置内禁用 hystrix
    /*@Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }*/
}
