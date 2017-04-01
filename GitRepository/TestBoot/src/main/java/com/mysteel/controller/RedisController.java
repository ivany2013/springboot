package com.mysteel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysteel.Config.RedisClient;

@RestController
public class RedisController {

	@Autowired
	private RedisClient redisClient;
	
	@RequestMapping("/get")
	public String getValue(String key) throws Exception{
		return redisClient.get(key);
	}
	@RequestMapping("/set")
	public String setValue(String key, String value) throws Exception{
		redisClient.set(key, value);
		return "success";
	}
	
	
}
