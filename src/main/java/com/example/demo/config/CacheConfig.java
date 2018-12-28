package com.example.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.Arrays;

/**
 * @author zypcid
 * @Title: CacheConfig
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1311:25
 */
public class CacheConfig extends CachingConfigurerSupport
{
    @Bean
   public CacheManager cacheManager(RedisTemplate redisTemplate)
   {
       RedisCacheManager  rcm=new RedisCacheManager(redisTemplate);
       rcm.setCacheNames(Arrays.asList("thisredis"));//设置缓存名称
       rcm.setDefaultExpiration(600);
       return rcm;
   }
   @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory)
   {
       StringRedisTemplate template=new StringRedisTemplate(redisConnectionFactory);
       Jackson2JsonRedisSerializer  jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
       ObjectMapper om=new ObjectMapper();
       om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
       om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
       jackson2JsonRedisSerializer.setObjectMapper(om);
       template.setValueSerializer(jackson2JsonRedisSerializer);
       template.afterPropertiesSet();
       return template;

   }
}
