package com.zacharychao.mvc.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zacharychao.mvc.user.entity.User;

@Mapper
public interface UserMapper {
	@Select("select * from user")
	public List<User> getAllUser();
}
