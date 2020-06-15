package com.cloud.rbacserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cloud.rbacserver.mapper")
public class RbacBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacBizApplication.class, args);
	}

}
