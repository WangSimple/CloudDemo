package com.cloud.rbacserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableDiscoveryClient
public class RbacBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacBizApplication.class, args);
	}



}
