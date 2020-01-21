package com.zacharychao.web.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zacharychao.web.mapper.DemoMapper;

@Service
@CacheConfig(cacheNames= {"webService_"})
public class WebService {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private DemoMapper demoMapper;
	
	public List<Map<String,Object>> getList(){
		ValueOperations opsForValue = redisTemplate.opsForValue();
		List<Map<String,Object>> testList = (List<Map<String,Object>>)opsForValue.get("testList");
		if(testList == null) {
			List<Map<String, Object>> allObject = demoMapper.getAllObject();
			opsForValue.set("testList", allObject);
			redisTemplate.expire("testList", 10, TimeUnit.MINUTES);
			return allObject;
		}
		return testList;
	}
	
	@Cacheable(key="'getAllObjectsByRedis'")
	public List<Map<String,Object>> getAllObjectsByRedis(){
		return demoMapper.getAllObject();
	}
	
	@CacheEvict(key="'getAllObjectsByRedis'")
	public void clear(){
		System.out.println("getAllObjectsByRedis 数据被清空");
	};
}
