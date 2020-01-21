package com.zacharychao.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zacharychao.web.mapper.DemoMapper;
import com.zacharychao.web.service.WebService;

@RestController
public class DemoController {
	@Autowired
	private WebService webService;
	
	@GetMapping("/test")
	@ResponseBody
	public List<Map<String,Object>> test(){
		return webService.getList();
	}
	
	@GetMapping("/getAllObjectsByRedis")
	public List<Map<String,Object>> getAllObjectsByRedis(){
		return webService.getAllObjectsByRedis();
	}
	@GetMapping("/clear")
	public void clear() {
		webService.clear();
	}
}
