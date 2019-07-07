package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/5/9 16:55
 * @Description: BLOCKED状态下的中断
 */
public class Case69_3 {

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();

        synchronized (lock){
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    while (!Thread.currentThread().isInterrupted()) {// 判断线程是否处于中断

                    }
                }
                System.out.println("exit...");
            });
            thread.start();

            Thread.sleep(1000);
            // 中断处于BLOCKED状态的线程
            thread.interrupt();
            /* 等待thread线程结束，此时一直持有lock对象的锁
            *  将此代码注释，程序能正常结束，否则，处于死循环，注释后主线程会释放持有的lock对象的锁，
            *  thread线程能获得锁，并执行run方法
            * */
            thread.join();
        }
    }

}
