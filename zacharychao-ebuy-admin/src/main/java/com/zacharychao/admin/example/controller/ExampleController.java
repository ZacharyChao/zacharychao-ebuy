package com.zacharychao.admin.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zacharychao.admin.example.mapper.TestMapper;
import com.zacharychao.admin.example.service.RedisService;

@RestController
public class ExampleController {
	@Autowired
	private RedisService redisService;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "index";
	}
	
	@GetMapping("/redis")
	@ResponseBody
	public void getRedisValue() {
		Object obj = redisService.getRedisValue();
		System.out.println(obj);
	}
}
