package com.ljz.test.thread.thread_pool;

public class TaskRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("自定义线程任务在执行" + i);
        }
    }
}