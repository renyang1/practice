package com.ry.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: renyang
 * @Date: 2019/8/15 16:34
 * @Description: 有A，B，C三个线程,，A线程输出A，B线程输出B， C线程输出C，要求，同时启动三个线程,，按顺序输出ABC，循环10次。
 */
public class PrintABC {
    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS
    , new LinkedBlockingDeque<>());

    /**
     * Description: 利用Semaphore实现
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/15 17:29
     */
    public void semaphorePrintABC() {
        for (int i = 0; i < 10; i++) {
            executor.execute(()-> print("A", semaphore1, semaphore2));
            executor.execute(()-> print("B", semaphore2, semaphore3));
            executor.execute(()-> print("C", semaphore3, semaphore1));
        }
        executor.shutdown();
    }

    /**
     * Description:
     * @auther: renyang
     * @param source: 需要打印的字符串
     * @param ac: 需要获取许可的对象
     * @param rl: 需要释放许可的对象
     * @return:
     * @date: 2019/8/15 17:31
     */
    private void print(String source, Semaphore ac, Semaphore rl) {
        try {
            ac.acquire();// 获取许可，许可数量permits-1
            System.out.println(source);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rl.release();// 释放许可，许可数量permits+1
        }
    }

    public static void main(String[] args) {
        new PrintABC().semaphorePrintABC();
    }
}
