package com.ljz.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("cacheDemoUserService")
public class CacheDemoUserServiceImpl {
    private Map<String, String> usersData = new ConcurrentHashMap<String, String>();

    public CacheDemoUserServiceImpl() {
        System.out.println("用户数据初始化...开始");
        usersData.put("1", "ljz1");
        usersData.put("2", "ljz2");
        usersData.put("3", "ljz3");
        usersData.put("4", "ljz4");
        System.out.println("用户数据初始化...完毕");
    }

    //将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key
    //通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值
    @Cacheable(value = "myCache", key = "'get'+#userNo")
    public String get(String userNo) {
        System.out.println("数据库中查到此用户号[" +
                userNo + "]对应的用户名为[" +
                usersData.get(userNo) + "]");
        return usersData.get(userNo);
    }

    @CacheEvict(value = "myCache", key = "'get'+#userNo")
    public void update(String userNo) {
        System.out.println("移除缓存中此用户号[" +
                userNo + "]对应的用户名[" +
                usersData.get(userNo) + "]的缓存");
    }

    //allEntries为true表示清除value中的全部缓存,默认为false
    @CacheEvict(value = "myCache", allEntries = true)
    public void removeAll() {
        System.out.println("移除缓存中的所有数据");
    }
}