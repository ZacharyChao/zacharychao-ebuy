package com.zacharychao.mvc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zacharychao.mvc.user.entity.User;
import com.zacharychao.mvc.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/users")
	@ResponseBody
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
}
