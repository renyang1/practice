package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/5/6 19:36
 * @Description: 线程协作之等待结束
 */
public class Case68_2 {

    /**
     * Description:等待结束
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/5/6 19:49
     */
    public void waitForAllEnd() throws InterruptedException{
        MyLatch latch = new MyLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.await();
        System.out.println("end...");
    }

    static class MyLatch {
        private int count;// 线程计数器，表示未完成线程个数

        public MyLatch(int count) {
            this.count = count;
        }

        /**
         * Description:主线程调用此方法后，等待子线程结束
         * @auther: renyang
         * @param:
         * @return:
         * @date: 2019/5/6 19:44
         */
        public synchronized void await() throws InterruptedException{
            while (count > 0) {
                System.out.println("wait...");
                wait();// 当未完成线程数不为0时，调用该方法的当前线程等待
            }
        }

        /**
         * Description:子线程调用，对未完成线程数减1
         * @auther: renyang
         * @param:
         * @return:
         * @date: 2019/5/6 19:47
         */
        public synchronized void countDown() {
            count--;
            if (count <= 0) {// 当未完成线程个数为零0时，唤醒所有等待的线程
                notifyAll();
            }
        }
    }
}

