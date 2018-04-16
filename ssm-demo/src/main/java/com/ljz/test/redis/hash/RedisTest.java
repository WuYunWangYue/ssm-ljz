package com.ljz.test.redis.hash;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        System.out.println("---------------------------------------------");
        System.out.println("存入Map集合类型的值");

        //Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。
        Map<String, String> map = new HashMap<>();
        map.put("name", "小明");
        map.put("age", "13");
        map.put("sex", "男");
        map.put("height", "174");

        //调用jedis的hmset(存入hash hash)的方法将map的键值对存进去
        jedis.hmset("people", map);


        //新建一个string类型的数组,用于存当时存入redis的map的key值
        String[] array = new String[map.size()];
        array[0] = "name";
        array[1] = "age";
        array[2] = "sex";
        array[3] = "height";

        //利用jedis的hmget方法,从数据库中依次取出对应的map的key值
        List<String> list = jedis.hmget("people", array);
        for (int i = 0; i < array.length; i++) {
            System.out.println("存入键值对为: " + array[i] + " = " + list.get(i));
        }
    }
}
