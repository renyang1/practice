package com.ry.laoma;

import java.util.concurrent.*;

/**
 * @Auther: renyang
 * @Date: 2019/3/4 09:55
 * @Description: Callable接口创建有返回值异步任务
 */
public class CallableTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
//        firstWay();
//        sencondWay();
        runnableTest();
    }

    /**
     * Description:先创建FutureTask对象，利用该对象获取异步结果信息
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/3/4 10:11
     */
    public static void firstWay() {

        long waitTime = 1000L;
        // 创建FutureTask对象
        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            long waitTime1 = waitTime;
            Thread.sleep(waitTime1);
            return Thread.currentThread().getName();
        });

        FutureTask<String> futureTask2 = new FutureTask<>(() -> {
            long waitTime2 = waitTime + 1000L;
            Thread.sleep(waitTime2);
            return Thread.currentThread().getName();
        });

        // 创建线程池并返回ExecutorService对象实例
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 执行任务1
        executor.execute(futureTask1);
        // 执行任务2
        executor.execute(futureTask2);

        // 判断任务是否执行完成
        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {// 两个任务均执行完成

                    System.out.println("All Finished");
                    executor.shutdown();
                    return;
                }

                if (!futureTask1.isDone()) {// 任务1没有完成，等待任务1完成
                    // 该方法会阻塞等待，直到任务完成
                    String thread1Name = futureTask1.get();
                    System.out.println(thread1Name);
                }

                System.out.println("waiting for futureTask2 to complete");
                // 超时等待，200s没返回则抛出TimeOutException
                String thread2Name = futureTask2.get(200L, TimeUnit.MILLISECONDS);

                if (thread2Name != null) {
                    System.out.println(thread2Name);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Description:通过ExecutorService的submit()方法执行任务，
     *             不用TaskFuture进行包装
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/3/4 14:19
     */
    public static void sencondWay() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(()->{
            return Thread.currentThread().getName();
        });

        try {
            String threadName = future.get();
            System.out.println(threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    /**
     * Description:利用Future获取Runnable异步任务结果
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/3/4 18:09
     */
    public static void runnableTest() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // submit参数为Runnable对象实例
        Future future = executor.submit(()-> {
            System.out.println("start...");
            try {
                Thread.sleep(2000L);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        boolean isDone = future.isDone();
        System.out.println(isDone);
        try {
            // 获取Runnable异步任务返回值
            Object object = future.get();
            System.out.println(object);// null
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    public String get() {
        String target = null;
        String result;
        try {
            int length = target.length();
            System.out.println(length);
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            result = "2";
        }
        return result;
    }

}
