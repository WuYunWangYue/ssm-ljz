package com.ljz.test.redis.zset;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        Map<String, Double> map = new HashMap<>();
        map.put("北京", 1.0);
        map.put("北京", 2.0);
        map.put("南京", 3.0);
        map.put("上海", 4.0);
        map.put("上海", 5.0);
        map.put("南京", 6.0);

        //调用jedis的zadd方法存入
        jedis.zadd("sorted set城市", map);

        //索引在0,到10之间的,分数由高到底的取出所有的集合
        Set<String> zrevrange = jedis.zrevrange("sorted set城市", 0, 10);
        System.out.println(zrevrange);
    }
}
