package com.ryang.bf.bfjczs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @Auther: renyang
 * @Date: 2019/5/6 11:13
 * @Description: 生产者消费者模型
 */
public class Case67 {

    public static void main(String[] args) {
        StoreHouse storeHouse = new StoreHouse(10);
        int number = 10;
        new Thread(() ->{// 生产者线程
            for (int i = 0; i < number; i++){
                try {
                    storeHouse.produce("" + i);
                    System.out.println("produce number " + i);
                    Thread.sleep(new Random(100).nextInt(9));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() ->{// 消费者线程
            for (int i = 0; i < number; i++){
                try {
                    storeHouse.consume();
                    System.out.println("consme number " + i);
                    Thread.sleep(new Random(100).nextInt(9));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class StoreHouse<E> {

    private final Queue<E> queue;
    private final int limit;

    public StoreHouse(int limit) {
        this.queue = new ArrayDeque<>(limit);
        this.limit = limit;
    }

    /**
     * Description: 生产者生产
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/5/6 11:26
     */
    public synchronized void produce(E e) throws InterruptedException {
        if (queue.size() == limit) {// 当库存满时，生产者停止生产
            wait();
        }
        queue.add(e);
        notifyAll();// 唤醒所有在等待的消费者开始消费
    }

    /**
     * Description:消费者消费
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/5/6 11:31
     */
    public synchronized E consume() throws InterruptedException {
        if (queue.isEmpty()) {// 库存为空时，消费者停止消费
            wait();
        }
        E e = queue.poll();
        notifyAll();// 唤醒生产者开始生产
        return e;
    }
}

