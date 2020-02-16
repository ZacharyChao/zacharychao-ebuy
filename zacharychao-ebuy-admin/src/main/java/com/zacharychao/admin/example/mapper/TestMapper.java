package com.zacharychao.admin.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
	@Select("select * from test")
	List<Map<String,Object>> getAllTest();
}
