//package com.douban.config;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * Created by ruikai.lin  on 2018/2/2 下午3:08.
// * Email: ruikai.lin@plusx.cn
// * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
// */
//@Configuration
//@EnableCaching
//public class RedisConfiguration {
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean(name = "redisTemplate")
//    public RedisTemplate<String, String> redisTemplate() {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        StringRedisSerializer redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setValueSerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        redisTemplate.setHashValueSerializer(redisSerializer);
//        return redisTemplate;
//    }
//
//    @Bean(name = "redisObjectTemplate")
//    public RedisTemplate<String,Object> redisObjectTemplate(){
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        RedisSerializer<Object> genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
//        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
//        return redisTemplate;
//    }
//
//    private long defaultExpireTime = 10;
//
//    @Bean
//    public RedisCacheManager cacheManager(RedisTemplate<String, Object> redisObjectTemplate) {
//        RedisCacheManager redisCacheManager = new RedisCacheManager(redisObjectTemplate);
//        redisCacheManager.setDefaultExpiration(defaultExpireTime);
//        return redisCacheManager;
//    }
//}
