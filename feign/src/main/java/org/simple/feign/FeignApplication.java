package org.simple.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@EnableDiscoveryClient
//@SpringBootApplication
//@EnableCircuitBreaker//对hystrix熔断器的支持
//SpringCloudApplication=SpringBootApplication+EnableDiscoveryClient+EnableCircuitBreaker
@EnableFeignClients
@ComponentScan
@SpringCloudApplication
public class FeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

}
