package com.mysteel.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	@Bean(name = "jedis.pool")
	@Autowired
	public JedisPool jedisPool(@Qualifier("jedis.pool.config")JedisPoolConfig jedisPoolConfig,@Value("${jedis.pool.host}") String host,@Value("${jedis.pool.port}") int port){
		return new JedisPool(jedisPoolConfig,host,port);
	}
	
	@Bean(name = "jedis.pool.config")/** 配置文件是我redis的地址 你需要改一下 */
	public JedisPoolConfig jedisPoolConfig(@Value("${jedis.pool.config.maxTotal}")int maxTotal,@Value("${jedis.pool.config.maxIdle}")int maxIdle,@Value("${jedis.pool.config.maxWaitMillis}")int maxWaitMillis){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxWaitMillis(maxWaitMillis);
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		return config;
	}
}
