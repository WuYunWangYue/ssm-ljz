package com.ljz.test.thread.daemon;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("当前时间: " + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);
        Date date = calendar.getTime();

        System.out.println("date: " + date);

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, date);
    }
}
