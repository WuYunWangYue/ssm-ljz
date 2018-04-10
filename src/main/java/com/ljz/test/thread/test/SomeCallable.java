package com.ljz.test.thread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SomeCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }

    public static void main(String[] args) {
        Callable callable = new SomeCallable();
        FutureTask task = new FutureTask(callable);
        Thread thread = new Thread(task);
        thread.start();
    }

}
