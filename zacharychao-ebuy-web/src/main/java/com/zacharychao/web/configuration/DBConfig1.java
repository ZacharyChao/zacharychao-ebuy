package com.zacharychao.web.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;
@Configuration
@PropertySource("classpath:config.properties")
public class DBConfig1 {
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.username}")
	private String username;
	@Value("jdbc.password")
	private String password;
	
	
	@Bean
	public DataSource dateSource() {
		DruidDataSource source = new DruidDataSource();
		source.setDriverClassName(driverClassName);
		source.setUrl(url);
		source.setUsername(username);
		source.setPassword(password);
		return source;
	}
	
}
