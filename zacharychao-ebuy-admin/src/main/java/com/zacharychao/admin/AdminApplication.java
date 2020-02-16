package com.zacharychao.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.zacharychao.admin.example.mapper"})
public class AdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
