package com.zacharychao.web.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableConfigurationProperties(JDBCProperty.class)
public class DBConfig2 {
	@Bean
	public DataSource dataSource(JDBCProperty jdbc) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(jdbc.getUrl());
		dataSource.setDriverClassName(jdbc.getDriverClassName());
		dataSource.setUsername(jdbc.getUsername());
		dataSource.setPassword(jdbc.getPassword());
		
		return dataSource;
	}
}
