package com.ry.thread;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/9 15:02
 * @Description: 死锁相关
 */
public class DeadLock {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public void lock1() {
        synchronized (obj1) {
            System.out.println(Thread.currentThread().getName() + "获取锁obj1成功！");
            try {
                Thread.sleep(1);
                lock2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void lock2() {
        synchronized (obj2) {
            System.out.println(Thread.currentThread().getName() + "获取锁obj2成功！");
            try {
                Thread.sleep(1);
                lock1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws Exception{
        Thread t1 = new Thread(()->lock1());
        t1.start();
        Thread t2 = new Thread(()->lock2());
        t2.start();
        t1.join();
        t2.join();
    }
}
