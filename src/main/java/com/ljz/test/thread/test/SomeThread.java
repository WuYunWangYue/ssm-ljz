package com.ljz.test.thread.test;

public class SomeThread extends Thread {
    public void run() {
        System.out.println("run...");
    }

    public static void main(String[] args) {
        SomeThread someThread = new SomeThread();
        someThread.start();
    }
}
