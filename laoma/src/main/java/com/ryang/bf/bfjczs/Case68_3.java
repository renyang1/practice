package com.ryang.bf.bfjczs;

import java.util.concurrent.Callable;

/**
 * @Auther: renyang
 * @Date: 2019/5/6 20:31
 * @Description: 线程协作之异步结果
 */
public class Case68_3 {

    public void asynchronousResult() {
        MyExecutor executor = new MyExecutor();
        // 子任务
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int millis = (int) (Math.random() * 1000);
                Thread.sleep(millis);
                return millis;
            }
        };

        // 异步调用，返回一个MyFuture对象
        MyFuture<Integer> future = executor.execute(task);
        try {
            // 获取异步调用结果
           Integer result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 封装主线程调用子线程
     * @auther: renyang
     * @param:
     * @return: 
     * @date: 2019/5/7 15:26
     */
    static class MyExecutor{

        public <V> MyFuture<V> execute(final Callable<V> task){
            final Object lock = new Object();
            final ExecuteThread<V> thread = new ExecuteThread<>(task, lock);
            thread.start();

            // 获取结果
            MyFuture<V> future = new MyFuture<V>() {
                @Override
                public V get() throws Exception {
                    synchronized (lock) {
                        while (!thread.isDone()){
                            lock.wait();
                        }
                        if (thread.getException() != null) {
                            throw thread.getException();
                        }
                        return thread.result;
                    }
                }
            };
            return future;
        }
    }

    /**
     * Description:内部类。创建子线程执行任务并返回结果
     * @auther: renyang
     * @param:
     * @return: 
     * @date: 2019/5/7 14:51
     */
    static class ExecuteThread<V> extends Thread{
        private V result = null;
        private Exception exception = null;
        private boolean done = false;
        private Callable<V> task;
        private Object lock;

        public ExecuteThread(Callable<V> task, Object lock){
            this.task = task;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                result = task.call();
            } catch (Exception e) {
                exception = e;
            }finally {
                synchronized (lock){// 唤醒在该对象上等待结果的线程
                    done = true;
                    lock.notifyAll();
                }
            }
        }

        public V getResult() {
            return result;
        }

        public boolean isDone() {
            return done;
        }

        public Exception getException() {
            return exception;
        }
    }

}

/**
 * Description: 异步调用结果接口
 * @auther: renyang
 * @param:
 * @return:
 * @date: 2019/5/7 14:47
 */
interface MyFuture <V> {
    V get() throws Exception;
}
