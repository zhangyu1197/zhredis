package com.example.demo.service.impl;

import com.example.demo.service.RedisService;
import org.springframework.stereotype.Service;

/**
 * @author zypcid
 * @Title: RedisServiceImpl
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1318:01
 */
@Service
public class RedisServiceImpl extends RedisService
{
    private static final String REDIS_KEY="TEST_REDIS_KEY";
    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
