package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/5/9 17:08
 * @Description: IO操作
 */
public class Case69_4 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    // 从标准输入读取一个字符
                    /*InputStream的read调用，该操作是不可中断的，如果流中没有数据，
                    read会阻塞 (但线程状态依然是RUNNABLE)，且不响应interrupt()*/
                    System.out.println(System.in.read());
                    System.out.println(Thread.currentThread().isInterrupted());
                } catch (Exception e) {
                    // 抛出异常后，中断标志位会被清空，而不是被设置
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
            System.out.println("exit...");
        });
        thread.start();

        // 保证子线程处于RUNNING
        Thread.sleep(100);
        // 中断线程
//        thread.interrupt();
    }
}
