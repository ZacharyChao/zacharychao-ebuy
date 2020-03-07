package com.zacharychao.admin.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.zacharychao.admin.example.mapper.TestMapper;

@Service
@CacheConfig(cacheNames= {"redisService_"})
public class RedisService {
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private TestMapper testMapper;
	
	public Object getRedisValue() {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		Object number = opsForValue.get("number");
		if(number == null) {
			redisTemplate.setKeySerializer(new StringRedisSerializer());
			number = testMapper.getAllTest();
			opsForValue.set("number", number);
		}
		return number; 
	}
	
}
