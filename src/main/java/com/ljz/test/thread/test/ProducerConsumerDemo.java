package com.ljz.test.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        /*
        if(flag)
            try{wait();}catch(Exception e){}
        this.name=name+"---"+count++;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
        flag=true;
        this.notify();
        */
        /*
        原先是if,现在改成while，这样生产者线程从冻结状态醒来时，还会再判断flag.
        */
        while (flag)
            try {
                wait();
            } catch (Exception e) {
            }
        this.name = name + "---" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        flag = true;
        /*
        原先是notity(), 现在改成notifyAll(),
        这样生产者线程生产完一个商品后可以将等待中的消费者线程唤醒，
        否则只将上面改成while后，可能出现所有生产者和消费者都在wait()的情况。
        */
        this.notifyAll();
    }

    public synchronized void out() {
        /*
        if(!flag)
            try{wait();}catch(Exception e){}
        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
        flag=false;
        this.notify();
        */
        /*
        原先是if,现在改成while，这样消费者线程从冻结状态醒来时，还会再判断flag.
        */
        while (!flag)
            try {
                wait();
            } catch (Exception e) {
            }
        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        flag = false;
        /*
        原先是notity(), 现在改成notifyAll(),
        这样消费者线程消费完一个商品后可以将等待中的生产者线程唤醒，
        否则只将上面改成while后，可能出现所有生产者和消费者都在wait()的情况。
        */
        this.notifyAll();
    }
}

class Resource2 {
    private String name;
    private int count = 1;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();/*Lock是一个接口，ReentrantLock是该接口的一个直接子类。*/
    private Condition condition_pro = lock.newCondition(); /*创建代表生产者方面的Condition对象*/
    private Condition condition_con = lock.newCondition(); /*使用同一个锁，创建代表消费者方面的Condition对象*/

    public void set(String name) {
        lock.lock();//锁住此语句与lock.unlock()之间的代码
        try {
            while (flag)
                condition_pro.await(); //生产者线程在condition_pro对象上等待
            this.name = name + "---" + count++;
            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
            flag = true;
            condition_con.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //unlock()要放在finally块中。
        }
    }

    public void out() {
        lock.lock(); //锁住此语句与lock.unlock()之间的代码
        try {
            while (!flag)
                condition_con.await(); //消费者线程在conndition_con对象上等待
            System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
            flag = false;
            condition_pro.signalAll(); /*唤醒所有在condition_pro对象下等待的线程，也就是唤醒所有生产者线程*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private Resource2 res;

    Producer(Resource2 res) {
        this.res = res;
    }

    public void run() {
        while (true) {
            res.set("商品");
        }
    }
}

class Consumer implements Runnable {
    private Resource2 res;

    Consumer(Resource2 res) {
        this.res = res;
    }

    public void run() {
        while (true) {
            res.out();
        }
    }
}

//运行结果正常，生产者生产一个商品，紧接着消费者消费一个商品。
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Resource2 r = new Resource2();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(pro);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}