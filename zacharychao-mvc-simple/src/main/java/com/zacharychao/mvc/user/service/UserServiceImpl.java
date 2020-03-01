package com.zacharychao.mvc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zacharychao.mvc.user.entity.User;
import com.zacharychao.mvc.user.mapper.UserMapper;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() {
		
		return userMapper.getAllUser();
	}

}
