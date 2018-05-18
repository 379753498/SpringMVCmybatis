package com.javen.Config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class RedisConfig {

	@Value("${redis.maxActive}")
	int maxTotal;
	@Value("${redis.maxIdle}")
	int maxIdle;
	@Value("${redis.maxWait}")
	int maxWaitMillis;
	@Value("${redis.testOnBorrow}")
	boolean testOnBorrow;

	@Bean
	public JedisPoolConfig getJedisPoolConfig() {
		JedisPoolConfig jedisConfig = new JedisPoolConfig();
		jedisConfig.setMaxTotal(maxTotal);
		jedisConfig.setMaxIdle(maxIdle);
		jedisConfig.setMaxWaitMillis(maxWaitMillis);
		jedisConfig.setTestOnBorrow(testOnBorrow);
		return jedisConfig;

	}

	@Value("${redis.host}")
	String hostName;

	@Value("${redis.port}")
	int port;
	@Value("${redis.password}")
	String redispassword;

	@Bean
	public JedisConnectionFactory getJedisConnectionFactory() {
		JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory();
		JedisConnectionFactory.setHostName(hostName);
		JedisConnectionFactory.setPort(port);
		JedisConnectionFactory.setPassword(redispassword);
		JedisConnectionFactory.setPoolConfig(getJedisPoolConfig());
		return JedisConnectionFactory;

	}

	@Bean
	public RedisTemplate<Serializable, Object> getRedisTemplate() {
		RedisTemplate<Serializable, Object> RedisTemplate = new RedisTemplate<Serializable, Object>();
		RedisTemplate.setConnectionFactory(getJedisConnectionFactory());
		RedisTemplate.setKeySerializer(new StringRedisSerializer());
		RedisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		RedisTemplate.setEnableDefaultSerializer(true);
		RedisTemplate.setEnableTransactionSupport(true);
		return RedisTemplate;
	}

}
