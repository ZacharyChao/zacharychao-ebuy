package com.zacharychao.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DemoMapper {
	@Select("select * from test")
	public List<Map<String,Object>> getAllObject(); 
}
