package com.ry.laoma;

/**
 * @Auther: renyang
 * @Date: 2018/7/17 19:14
 * @Description: 生产者/消费者模式中的消费者类，协作的共享变量是队列
 */
public class Producer_67 implements Runnable {

    private MyBlockingQueue_67<String> queue;

    public Producer_67(MyBlockingQueue_67<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        int num = 0;
        try{
            while (true){
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("produce task " + task);
                num++;
                Thread.sleep((int)(Math.random()*1000));
            }
        }catch (InterruptedException e){
            //todo:
        }
    }
}
