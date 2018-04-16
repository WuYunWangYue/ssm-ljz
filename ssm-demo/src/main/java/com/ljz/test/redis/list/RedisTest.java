package com.ljz.test.redis.list;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        System.out.println("---------------------------------------------");
        System.out.println("存入list集合类型的值");

        jedis.lpush("list城市", "南京");
        jedis.lpush("list城市", "上海");
        jedis.lpush("list城市", "苏州");
        jedis.lpush("list城市", "北京");
        jedis.lpush("list城市", "南通");

        List<String> list = jedis.lrange("list城市", 0, 100);
        System.out.println(list.size());
        for (String string : list) {
            System.out.println("city : " + string);
        }
    }
}
