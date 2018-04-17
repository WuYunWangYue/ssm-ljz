package com.ljz;

import com.ljz.common.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@WebAppConfiguration
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testOne() {
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
    public void testTwo() {
        redisUtil.set("name", "ljz");
        redisUtil.set("age", "24");
        redisUtil.set("address", "河北邯郸");

        System.out.println(redisUtil.get("age"));

    }

    @Test
    public void testThree() {
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush("testThree", "1");
        listOperations.leftPush("testThree", "2");

        List<String> list = listOperations.range("testThree", 0, 10);
        System.out.println(list);
    }

    @Test
    public void testFour() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, String> map = new HashMap<>();
        map.put("name", "ljz");
        map.put("age", "29");
        map.put("address", "浦江镇汇臻路");

        hashOperations.putAll("me", map);
        Set<Object> set = hashOperations.keys("me");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Object value = hashOperations.get("me", key);
            System.out.println(key + " : " + value);
        }

//        for (Object key : set) {
//            Object value = hashOperations.get("people2", key);
//            System.out.println(key+" : "+value);
//        }

    }

    @Test
    public void testFive() {
        SetOperations<String, String> redisSet = redisTemplate.opsForSet();
        String[] arr = new String[5];
        arr[0] = "南京";
        arr[1] = "北京";
        arr[2] = "上海";
        arr[3] = "北京";
        arr[4] = "南京";

        redisSet.add("city", arr);

        Set<String> members = redisSet.members("city");
        System.out.println(members);

    }

    @Test
    public void testSix() {
        ZSetOperations<String, String > redisZSet = redisTemplate.opsForZSet();

        //存值,存value的同时,还加上顺序
        redisZSet.add("city2", "南京", 1);
        redisZSet.add("city2", "北京", 2);
        redisZSet.add("city2", "东京", 3);
        redisZSet.add("city2", "西京", 4);
        redisZSet.add("city2", "上海", 5);
        redisZSet.add("city2", "广州", 6);

        //获取范围顺序里面的值
        Set<String> rangeByScore = redisZSet.rangeByScore("city2", 1, 10);
        System.out.println(rangeByScore);
    }

}
