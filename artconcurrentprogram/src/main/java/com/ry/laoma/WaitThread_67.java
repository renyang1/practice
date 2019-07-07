package com.ry.laoma;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/7/17 12:41
 * @Description: 展示多线程基本协作机制中的共享变量个条件
 */
public class WaitThread_67 extends Thread{

    private volatile boolean fire = false;

    @Test
    public void test1() throws Exception{
        WaitThread_67 t1 = new WaitThread_67();
        t1.start();
        System.out.println(fire);
        Thread.sleep(1000);
        t1.changeFire();
        Thread.sleep(1000);
        System.out.println(fire);//?为什么这里fire的值还是false
    }

    @Override
    public void run() {
        try{
            synchronized (this){
                while (!fire){
                    this.wait();
                }
            }
            System.out.println("hello...");
        }catch (InterruptedException e){}
    }

    public synchronized void changeFire(){
        this.fire = true;
        this.notifyAll();
    }
}
