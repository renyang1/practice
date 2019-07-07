package com.ry;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: renyang
 * @Date: 2019/2/1 14:37
 * @Description: 使用信号量Semaphore解决并发相关问题，如三个线程依次打印A、B、C
 */
public class SemaphoreTset {

    private final int times = 5;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {

        SemaphoreTset semaphoreTset = new SemaphoreTset();

        // 使用Runnable接口的方式创建线程A
        new Thread(() -> semaphoreTset.printA()).start();

        // 创建线程池，执行线程B、C
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

        executor.execute(() -> semaphoreTset.printB());
        executor.execute(() -> semaphoreTset.printC());
        executor.shutdown();
    }

    private void printA() {
        try {
            print("A", semaphoreA, semaphoreB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printB() {
        try {
            print("B", semaphoreB, semaphoreC);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printC() {
        try {
            print("C", semaphoreC, semaphoreA);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String content, Semaphore current, Semaphore next) throws InterruptedException {

        for (int i = 0; i < times; i++) {
            // 获取当前线程执行需要的许可
            current.acquire();
            System.out.println(content);
            // 将下一个线程执行需要的许可+1
            next.release();
        }
    }
}