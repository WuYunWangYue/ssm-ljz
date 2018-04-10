package com.ljz.test.thread.test;

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

//        new MyThread("低级", 1).start();
//        new MyThread("--中级", 5).start();
//        new MyThread("----高级", 10).start();

        MyThread myThread1 = new MyThread("低级", 1);
        myThread1.start();
        MyThread myThread2 = new MyThread("高级", 5);
        myThread2.start();
        myThread2.join();

    }
}
