package com.ryang.thread.threadpool;

import java.util.concurrent.*;

/**
 * @Auther: renyang
 * @Date: 2019/8/8 11:48
 * @Description: ThreadPoolExecutor创建线程池
 */
public class ThreadPoolExecutorDemo {

    private static ThreadPoolExecutor pool;

    public static void main(String[] args) {
       /* // 创建线程池
        pool = new ThreadPoolExecutor(2, 20, 0L
                , TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024)
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        // 关闭线程池
        pool.shutdown();*/
//        useSynchronousQueue();
//        useArrayBlockingQueue();
//        useMyThreadFactory();
        expandThreadPoolExecutor();
    }

    /**
     * Description: SynchronousQueue（直接提交队列）
     * @auther: renyang
     * @param:
     * @return: 
     * @date: 2019/8/13 16:19
     */
    public static void useSynchronousQueue() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 1000
                , TimeUnit.MILLISECONDS, new SynchronousQueue<>()
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            pool.execute(()-> System.out.println(Thread.currentThread().getName()));
            /*try {
                // 这里在每个线程创建后增加sleep时间，可以保证在创建线程的时候，创建的线程数始终小于maximumPoolSize，而不是执行拒绝策略。
                // 反之若不增加sleep时间，对各线程同时创建，则会超过maximumPoolSize时，就会执行拒绝策略
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        // 关闭线程池
        pool.shutdown();
    }

    /**
     * Description: ArrayBlockingQueue(有界任务队列)
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/13 16:20
     */
    public static void useArrayBlockingQueue() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 1000
                , TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5)
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 这里创建线程数<= 7时，poolSize为2
        // 7 < 创建线程数 <= 10时，poolSize为5
        // 创建线程数>10时，会执行拒绝策略，抛出异常
        for (int i = 0; i < 11; i++) {
            pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        int poolSize = pool.getPoolSize();
        System.out.println(poolSize);
        pool.shutdown();
    }

    /**
     * Description:使用自定义的ThreadFactory,ThreadFactory是一个函数式接口，使用lambda表达式
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/13 19:33
     */
    public static void useMyThreadFactory() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 1000
                , TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5)
                , runnable -> new Thread(runnable, "threadPool" + runnable.hashCode())
                , new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 7; i++) {
            pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        pool.shutdown();
    }

    /**
     * Description: 扩展ThreadPoolExecutor：主要是围绕beforeExecute()、afterExecute()和terminated()三个接口实现的
     *              1、beforeExecute：线程池中任务运行前执行
     *              2、afterExecute：线程池中任务运行完毕后执行
     *              3、terminated：线程池退出后执行
     * @auther: renyang
     * @param:
     * @return: 
     * @date: 2019/8/13 19:59
     */
    public static void expandThreadPoolExecutor() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 1000
                , TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5)
                , runnable -> new Thread(runnable, "threadPool" + runnable.hashCode())
                , new ThreadPoolExecutor.AbortPolicy()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行："+ ((ThreadTask)r).getTaskName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完毕："+((ThreadTask)r).getTaskName());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        for(int i=0;i<10;i++) {
            pool.execute(new ThreadPoolExecutorDemo().new ThreadTask("Task"+i));
        }
        pool.shutdown();
    }

    class ThreadTask implements Runnable{
        // todo: 当线程有属性时，怎么用lambda表达式表示？
        private String taskName;
        public String getTaskName() {
            return taskName;
        }
        // todo:这里怎么用lambda表达式写？
        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }
        public ThreadTask(String name) {
            this.setTaskName(name);
        }
        public void run() {
            //输出执行线程的名称
            System.out.println("TaskName"+this.getTaskName()+"---ThreadName:"+Thread.currentThread().getName());
        }
    }
}
