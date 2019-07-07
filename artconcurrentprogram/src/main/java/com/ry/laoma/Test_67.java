package com.ry.laoma;

/**
 * @Auther: renyang
 * @Date: 2018/7/17 19:56
 * @Description:
 */
public class Test_67 {


    public static void main(String[] args){
        MyBlockingQueue_67 queue = new MyBlockingQueue_67(10);

        Producer_67 producer = new Producer_67(queue);
        Thread t1 = new Thread(producer);

        Consumer_67 consumer = new Consumer_67(queue);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
