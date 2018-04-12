package com.ljz.test.redis.string;

import redis.clients.jedis.Jedis;

public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        System.out.println("---------------------------------------------");
        System.out.println("存入string类型的值");

        jedis.set("string城市", "南京");
        String city = jedis.get("string城市");
        System.out.println("city = " + city);
    }
}
