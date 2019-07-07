package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/5/6 17:38
 * @Description: 线程的基本协作机制场景测试
 */
public class Case68_1 {

    FireFlag fireFlag = new FireFlag();

    /**
     * Description:模拟线程协作同时开始场景
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/5/6 19:30
     */
    public void startAtSameTime() throws InterruptedException {
        new Thread(() -> { // 模拟一个运动员
            try {
                fireFlag.waitForFired();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> { // 模拟一个运动员
            try {
                fireFlag.waitForFired();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);
        fireFlag.fire(false);

        Thread.sleep(1000);
        fireFlag.fire(true);
    }

}

/**
 * Description: 模拟线程协作同时开始场景
 * @auther: renyang
 * @param:
 * @return:
 * @date: 2019/5/6 17:42
 */
class FireFlag {
    private volatile boolean fired = false;// 信号

    public synchronized void waitForFired() throws InterruptedException{
        while (!fired) {// 判断是否需要等待
            System.out.println("judge...");
            wait();
            System.out.println("1");// 这里在线程被唤醒并拿到锁后，不管while中的条件是否满足都会执行
        }
        System.out.println("end...");// 条件满足后while循环才会退出，这里代码才会执行
    }

    public synchronized void fire(boolean fired1){
        this.fired = fired1;
        notifyAll();
    }
}
