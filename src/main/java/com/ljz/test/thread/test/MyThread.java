package com.ljz.test.thread.test;

class MyThread extends Thread {
    public MyThread(){}

    public MyThread(String name, int pro) {
        super(name);// 设置线程的名称  
        this.setPriority(pro);// 设置优先级  
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(this.getName() + "线程第" + i + "次执行！");
            if (i % 2 == 0)
                Thread.yield();
        }
    }
} 