package com.ry.thread;

import java.util.concurrent.*;

/**
 * @Auther: renyang
 * @Date: 2019/8/15 17:41
 * @Description: 用多线程去处理"abc"，"def"，“ghi”这个三个字符串，让它们以"adg"，"beh"，“cfi”这种形式输出
 */
public class Print {
    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);
    private String s1 = "abc";
    private String s2 = "def";
    private String s3 = "ghi";

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
        for (int i = 0; i < 3; i++) {
            final int index = i;
            StringBuilder sb = new StringBuilder();
            // 这里需要使用submit()方式提交，因为需要控制三个线程都执行完了才进行一次输出
            Future future1 = executor.submit(()-> print(sb, s1.substring(index, index + 1), semaphore1, semaphore2));
            Future future2 = executor.submit(()-> print(sb, s2.substring(index, index + 1), semaphore2, semaphore3));
            Future future3 = executor.submit(()-> print(sb, s3.substring(index, index + 1), semaphore3, semaphore1));
            while (true) {
                if (future1.isDone() && future2.isDone() && future3.isDone()) {
                    System.out.println(sb.toString());
                    break;
                }
            }
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
    private void print(StringBuilder sb, String source, Semaphore ac, Semaphore rl) {
        try {
            ac.acquire();// 获取许可，许可数量permits-1
            sb.append(source);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rl.release();// 释放许可，许可数量permits+1
        }
    }

    public static void main(String[] args) {
        new Print().semaphorePrintABC();
    }

}
