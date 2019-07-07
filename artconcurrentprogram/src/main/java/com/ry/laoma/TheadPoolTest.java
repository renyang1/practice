package com.ry.laoma;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: renyang
 * @Date: 2019/1/22 15:33
 * @Description: 线程池demo
 */
public class TheadPoolTest {

    public static void main(String[] args) {
        method();
    }

    public static void method(){

        // 创建线程池对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 20; i++) {
            MyTask1 task1 = new MyTask1(i);
            executor.execute(task1);
//            MyTask2 task2 = new MyTask2(i);
//            executor.execute(task2);
//            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
//                    executor.getQueue().size()+"，已执行完成的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask1 implements Runnable {

    private int taskNum;

    public MyTask1(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {

//        System.out.println("业务一正在执行task: " + taskNum + "...");
        // 线程休眠4s
        try{
            Thread.currentThread().sleep(4000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + " 业务一执行task: " + taskNum + "完毕！");
    }
}


class MyTask2 implements Runnable {

    private int taskNum;

    public MyTask2(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("业务二正在执行task: " + taskNum + "...");

        // 线程休眠4s
        try{
            Thread.currentThread().sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务二执行task: " + taskNum + "完毕！");
    }
}