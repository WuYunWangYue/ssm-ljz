package com.ljz;

import com.ljz.common.util.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;

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

    @Test
    public void Test02() {
        redisUtil.set("name", "ljz");
        redisUtil.set("age", "24");
        redisUtil.set("address", "河北邯郸");

        System.out.println(redisUtil.get("age"));

    }

}
