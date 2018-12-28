package com.example.demo.controller;

import com.example.demo.po.RedisModel;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zypcid
 * @Title: TestController
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1318:08
 */
@Controller
public class TestController
{
    @Autowired
    private RedisService redisService;
    @GetMapping("/add")
    @ResponseBody
    public void test()
    {
        System.out.println("start.......");
        RedisModel model=new RedisModel();
        model.setName("张三");
        model.setTel("00000");
        model.setAddress("深圳");
        model.setRedisKey("zhangsanKey0");
        redisService.put(model.getRedisKey(), model, -1);
        RedisModel model1=new RedisModel();
        model1.setName("张三1");
        model1.setTel("11111");
        model1.setAddress("深圳1");
        model1.setRedisKey("zhangsanKey1");
        redisService.put(model1.getRedisKey(),model1,-1);
        RedisModel model2=new RedisModel();
        model2.setName("张三2");
        model2.setTel("22222");
        model2.setAddress("深圳2");
        model2.setRedisKey("zhangsanKey2");
        redisService.put(model2.getRedisKey(), model2, -1);
    }
    @GetMapping("/get")
    @ResponseBody
    public Object get()
    {
        RedisModel m=new RedisModel();
        m.setRedisKey("zhangsanKey1");
        return  redisService.get(m.getRedisKey());
    }
    @GetMapping("/getAll")
    @ResponseBody
    public Object getAll()
    {
        return redisService.getAll();
    }
    @GetMapping("/getKeys")
    @ResponseBody
    public Object getKeys()
    {
        return redisService.getKeys();
    }
    @GetMapping("/remove")
    @ResponseBody
    public void remove() {
        RedisModel m = new RedisModel();
        m.setRedisKey("zhangsanKey1");
        redisService.remove(m.getRedisKey());
    }
    @GetMapping("/isKeyExists")
    @ResponseBody
    public void isKeyExists()
    {
        RedisModel m=new RedisModel();
        m.setRedisKey("zhangsanKey01");
        boolean flag=redisService.isKeyExists(m.getRedisKey());
        System.out.println("zhangsanKey01 是否存在:"+flag);
    }
    @GetMapping("/count")
    @ResponseBody
    public Object count() {
        return redisService.count();
    }
    @GetMapping("/empty")
    @ResponseBody
    public void empty()
    {
        redisService.empty();
    }

}
