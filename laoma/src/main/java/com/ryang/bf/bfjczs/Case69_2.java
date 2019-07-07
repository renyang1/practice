package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/5/9 16:46
 * @Description: WAITING/TIMED_WAITING状态下的中断
 */
public class Case69_2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 抛出异常后，中断标志位会被清空，而不是被设置
                System.out.println(Thread.currentThread().isInterrupted());
            }
            System.out.println("exit...");
        });
        thread.start();

        // 保证子线程处于RUNNING
        Thread.sleep(100);
        // 中断线程
        thread.interrupt();
    }
}
