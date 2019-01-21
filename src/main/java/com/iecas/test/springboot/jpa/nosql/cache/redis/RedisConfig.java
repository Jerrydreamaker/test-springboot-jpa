package com.iecas.testspringboot.nosql.cache.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class RedisConfig {
    @Bean
    public JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        /*
        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(3);
        poolConfig.setMaxTotal(10);*/
        return poolConfig;
    }
    @Bean
    public JedisConnectionFactory getJedisConnectionFactory(JedisPoolConfig poolConfig){
        JedisConnectionFactory connectionFactory=new JedisConnectionFactory();
        /*
        connectionFactory.setHostName("localhost");
        connectionFactory.setPort(6379);
        connectionFactory.setDatabase(1);*/
        connectionFactory.setPoolConfig(poolConfig);
        return connectionFactory;
    }
    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(JedisConnectionFactory connectionFactory){
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
