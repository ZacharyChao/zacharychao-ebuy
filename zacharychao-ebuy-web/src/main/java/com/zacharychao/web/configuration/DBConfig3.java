package com.zacharychao.web.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DBConfig3 {
	
	@Bean
	@ConfigurationProperties(prefix="jdbc")
	public DruidDataSource dataSource_() {
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}
}
