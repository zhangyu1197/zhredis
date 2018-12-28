package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zypcid
 * @Title: RedisConfig
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1315:29
 */
@Configuration
public class RedisConfig
{
    @Autowired
    RedisConnectionFactory  redisConnectionFactory;
    @Bean
    public RedisTemplate<String,Object> functionDomainRedisTemplate()
    {
         RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
         initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
         return redisTemplate;
    }
    //设置数据存入redis的序列化方式
    private void initDomainRedisTemplate(RedisTemplate<String,Object> redisTemplate,RedisConnectionFactory factory)
    {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
    }
    //实例化HashOperations对象,可以使用 Hash类型操作
    @Bean
    public HashOperations<String,String,Object> hashOperations(RedisTemplate<String,Object> redisTemplate)
    {
        return redisTemplate.opsForHash();
    }
    //String
    @Bean
    public ValueOperations<String,Object> valueOperations(RedisTemplate<String,Object> redisTemplate)
    {
        return redisTemplate.opsForValue();
    }
    //List
    @Bean
    public ListOperations<String,Object> listOperations(RedisTemplate<String,Object> redisTemplate)
    {
        return redisTemplate.opsForList();
    }
    //Set
    @Bean
    public SetOperations<String,Object> setOperations(RedisTemplate<String,Object> redisTemplate)
    {
        return redisTemplate.opsForSet();
    }
    //Zset
    @Bean
    public ZSetOperations<String,Object> zSetOperations(RedisTemplate<String,Object> redisTemplate)
    {
        return redisTemplate.opsForZSet();
    }

}
