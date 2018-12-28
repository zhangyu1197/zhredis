package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zypcid
 * @Title: RedisService
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1316:01
 */
public abstract class RedisService<T>
{
    @Autowired
    protected RedisTemplate<String,Object> redisTemplate;
    @Resource
    protected HashOperations<String,String,T> hashOperations;
    //存入redis中的key
    protected abstract String getRedisKey();
    public void put(String key, T domain,long expire)
    {
        hashOperations.put(getRedisKey(), key, domain);
        if(expire!= -1)
        {
            redisTemplate.expire(getRedisKey(),expire, TimeUnit.SECONDS);
        }
    }
    public void remove(String key)
    {
        hashOperations.delete(getRedisKey(),key);
    }
    public T get(String key)
    {
        return hashOperations.get(getRedisKey(),key );
    }
    public List<T> getAll() {
        return hashOperations.values(getRedisKey());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */

    public long count() {
        return hashOperations.size(getRedisKey());
    }

    /**
     * 清空redis
     */
    public void empty() {
        Set<String> set = hashOperations.keys(getRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getRedisKey(), key));
    }
}
