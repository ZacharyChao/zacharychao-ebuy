package com.zacharychao.admin.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	@GetMapping("/test")
	public String test() {
		return "index";
	}
}
