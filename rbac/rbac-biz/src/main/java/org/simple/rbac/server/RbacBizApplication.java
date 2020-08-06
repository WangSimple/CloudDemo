package org.simple.rbac.server;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//activiti 需要exclude SecurityAutoConfiguration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
@EnableDiscoveryClient
public class RbacBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacBizApplication.class, args);
	}



}
