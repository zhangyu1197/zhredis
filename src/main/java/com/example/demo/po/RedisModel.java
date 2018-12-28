package com.example.demo.po;

import java.io.Serializable;

/**
 * @author zypcid
 * @Title: RedisModel
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1315:57
 */
public class RedisModel implements Serializable
{
    private String redisKey;
    private String name;
    private String tel;
    private String address;
    public String getRedisKey()
    {
        return redisKey;
    }
    public void setRedisKey(String redisKey)
    {
        this.redisKey=redisKey;
    }
    public String getName()
    {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
