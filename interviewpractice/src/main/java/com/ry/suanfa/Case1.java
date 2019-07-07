package com.ry.suanfa;

import java.util.concurrent.Semaphore;

/**
 * @Auther: renyang
 * @Date: 2019/4/24 09:16
 * @Description:
 * 有字符串123456789这样的, 有两个线程同时执行,实现一下一次循环遍历出123456789
 * 例如 t1线程结果是1 t2线程结果是2 再是t1 = 3这样的.
 */
public class Case1 {

    /**
     * Description:循环输出
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/4/24 9:17
     */
    Semaphore t1 = new Semaphore(1);
    Semaphore t2 = new Semaphore(0);


    public void loopOutput(){
        thread1Print();
        thread2Print();
    }

    private void thread1Print() {
        new Thread(()->{
            try {
                for (int i = 1; i < 10; i += 2){
                    // 获取许可
                    t1.acquire();
                    Thread.currentThread().setName("线程1");
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    // 释放许可
                    t2.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void thread2Print() {
        new Thread(()->{
            try {
                for (int i = 2; i < 10; i += 2){
                    // 获取许可
                    t2.acquire();
                    Thread.currentThread().setName("线程2");
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    // 释放许可
                    t1.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
