package org.simple.provider.consumer.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CloudConfig {

    @Bean
    @LoadBalanced//负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
