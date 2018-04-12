package com.ljz.test.redis.set;

import redis.clients.jedis.Jedis;

import java.util.*;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        System.out.println("---------------------------------------------");
        System.out.println("存入Set集合类型的值");

        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("南京");
        list.add("上海");
        list.add("北京");
        list.add("北京");
        list.add("上海");
        list.add("苏州");
        list.add("南京");
        //打印源数据
        System.out.println("源数据为 : " + list);

        //因为jedis的sadd的方法,存入的是一个数组对象或者多数据,所有将集合对象转换成数组对象
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        //调用sadd方法存入数据库
        jedis.sadd("set城市", arr);

        Set<String> cities = jedis.smembers("set城市");
        System.out.println("获取结果 : " + cities);
    }
}
