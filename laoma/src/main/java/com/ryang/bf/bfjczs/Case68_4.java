package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/5/6 20:31
 * @Description: 线程协作之集合点
 */
public class Case68_4 {

    public void assemblePoint(){
        AssemblePoint point = new AssemblePoint(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 模拟各自独立运行
                    Thread.sleep((int) Math.random()*1000);
                    // 集合点
                    System.out.println("wait...");
                    point.await();
                    System.out.println("all arrived");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    static class AssemblePoint{
        private int n;// 需要集合的线程数

        public AssemblePoint(int n) {
            this.n = n;
        }

        public synchronized void await() throws InterruptedException{
            if (n > 0){
                n--;// 到达集合点进行减1操作
                if (n == 0){// 若是最后一个线程，则唤醒别的所有等待在该对象上的线程
                    notifyAll();
                }else {// 若不是最后一个线程，则线程等待
                    while (n != 0 ){// wait()的一般调用模式，while循环包裹
                        wait();
                    }
                }
            }
        }
    }
}
