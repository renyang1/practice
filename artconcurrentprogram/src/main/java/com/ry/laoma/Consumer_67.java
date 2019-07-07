package com.ry.laoma;

/**
 * @Auther: renyang
 * @Date: 2018/7/17 19:51
 * @Description:
 */
public class Consumer_67 implements Runnable {

    MyBlockingQueue_67<String> queue;

    public Consumer_67(MyBlockingQueue_67<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {

        try{
            while (true){
                String task = queue.take();
                System.out.println("handle task " + task);
                Thread.sleep((int) (Math.random() * 1000));
            }
        }catch (InterruptedException e){}
    }
}
