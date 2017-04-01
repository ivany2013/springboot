package com.mysteel.Config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisClient {

	@Autowired
	private JedisPool jedisPool;
	
	/**
	 * 说明：普通存取
	 * @param @param key<String>
	 * @param @param value<String>
	 * @param @throws Exception
	 * @author XuL  2017年4月1日
	 */
	public void set(String key,String value) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		}finally{
			jedis.close();
		}
	}
	
	public String get(String key) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.get(key);
		}finally{
			jedis.close();
		}
	}
	
	/**
	 * 说明：普通存取
	 * @param @param key<String>
	 * @param @param Map<String ,String>
	 * @author XuL  2017年4月1日
	 */
	
	public void setMap(String key,Map<String, String> map){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(key, map);
		}finally{
			jedis.close();
		}
	}
	public List<String> getMap(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hmget(key);
		}finally{
			jedis.close();
		}
	}
	
	public List<String> getMapFields(String key,String fields){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hmget(key, fields);
		}finally{
			jedis.close();
		}
	}
	
	/**
	 * 说明：将自定义对象 利用  FastJson 转换 存储 
	 * @param @param key
	 * @param @param obj
	 * @author XuL  2017年4月1日
	 */
	public void setObj(String key, Object obj){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String strObj = JSON.toJSONString(obj);
			jedis.set(key, strObj);
		}finally{
			jedis.close();
		}
	}
	
	public Object getObj(String key,Class<?> clazz){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String strObj = jedis.get(key);
			return JSON.parseObject(strObj,clazz);
		}finally{
			jedis.close();
		}
	}
	
	/**
	 * 说明：将自定义对象 利用  序列号 反序列化  转换 存储 
	 * 
	 * */
	//TODO
}
