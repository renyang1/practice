package com.ry;

/**
 * @Auther: renyang
 * @Date: 2019/1/29 11:24
 * @Description:
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    Object testString = new Object();

    public void test() {
        System.out.println("testString的hashCode" + testString.hashCode());
        System.out.println(threadLocal1.hashCode());
        Thread t1 = new Thread(() -> {
            threadLocal1.set("当前线程：" + Thread.currentThread().getId());
            String s = threadLocal1.get();
            System.out.println(s);
        });
        t1.start();
//        String s = threadLocal1.get();
//        System.out.println(s);
    }

    public static void main(String[] args) {
        new ThreadLocalTest().test();
        new ThreadLocalTest().test();

    }

}
