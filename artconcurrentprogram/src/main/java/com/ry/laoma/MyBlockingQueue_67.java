package com.ry.laoma;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Auther: renyang
 * @Date: 2018/7/17 19:21
 * @Description: 自定义阻塞队列
 */
public class MyBlockingQueue_67<E> {

    private Queue<E> queue = null;
    private int limit;

    public MyBlockingQueue_67(int limit){
        this.limit = limit;
        queue = new ArrayDeque<>(limit);
    }

    public synchronized void put(E e) throws InterruptedException{
        while (queue.size() == limit){
            wait();
        }
        queue.add(e);
        notifyAll();
    }

    public synchronized E take() throws InterruptedException{
        while (queue.isEmpty()){
            wait();
        }
        E e = queue.poll();
        notifyAll();
        return e;
    }
}
