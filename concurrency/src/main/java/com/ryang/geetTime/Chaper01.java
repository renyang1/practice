package com.ryang.geetTime;

/**
 * @Auther: renyang
 * @Date: 2019/3/6 14:37
 * @Description:
 */
public class Chaper01 {

    private volatile int count = 0;
//    private  AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(new Chaper01().calc());
    }

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count++;
        }
    }

    public long calc() {
        final Chaper01 test = new Chaper01();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 注意这里需返回test.count,若是返回count,则返回值为0
        return test.count;
//        return test.count.get();
    }
}

