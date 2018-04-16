package com.ljz.test.thread.test;

import java.util.TimerTask;

public class test1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
//        myThread.start();
//        myThread.sleep(100);
//        Thread.sleep(10);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main" + i);
//        }

//        new MyThread("低级", Thread.MIN_PRIORITY).start();
//        new MyThread("--中级", Thread.NORM_PRIORITY).start();
//        new MyThread("----高级", Thread.MAX_PRIORITY).start();

        MyThread myThread1 = new MyThread("低级", Thread.MIN_PRIORITY);
//        myThread1.setDaemon(true);
        myThread1.start();
        MyThread myThread2 = new MyThread("高级", Thread.MAX_PRIORITY);
        myThread2.start();
        myThread2.join(100);
        System.out.println(myThread2.isAlive());

    }
}
