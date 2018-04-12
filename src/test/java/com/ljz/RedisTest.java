package com.ljz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
@WebAppConfiguration
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void Test01(){
        //通过模板,获取到String类型的redis对象
        ValueOperations<String, String> redisString = redisTemplate.opsForValue();

        //使用set方法,保存key和value的值
        redisString.set("city", "南京");
        redisString.set("city", "上海");

        //使用get(key)的方法获取到city对应的值
        String string = redisString.get("city");
        System.out.println(string);
    }

}
