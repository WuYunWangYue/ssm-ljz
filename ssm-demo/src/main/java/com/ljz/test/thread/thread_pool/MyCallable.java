package com.ljz.test.thread.thread_pool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    //成员变量
    private int x;
    private int y;

    //构造方法
    public MyCallable() {
    }

    public MyCallable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x + y;
    }
}