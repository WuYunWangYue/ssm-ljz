package com.ljz.test.thread.test;

public class SomeRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("run...");
    }

    public static void main(String[] args) {
        Thread oneThread = new Thread(new SomeRunnable());
        oneThread.start();
    }
}
