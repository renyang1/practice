package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/5/9 16:17
 * @Description: RUNNABLE状态下的中断
 */
public class Case69_1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){// 判断线程是否中断
                // do nothing
            }
            System.out.println("exit...");
        });
        thread.start();

        Thread.sleep(500);
        // 中断线程
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

}
