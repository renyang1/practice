package com.ryang.designpatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: renyang
 * @Date: 2019/8/12 10:55
 * @Description: 单例模式
 */
public class Singleton1 {
    private static Singleton1 instance;// 懒汉返回对象
    private static volatile Singleton1 instance1;// 懒汉返回对象
    private static Singleton1 instance2 = new Singleton1();// 饿汉返回对象

    // 构造函数声明为private
    private Singleton1() {}

    /**
     * Description:懒汉，线程不安全
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/12 11:11
     */
    public static Singleton1 getInstance() {
        if (instance == null) {// InstallCert、B线程同时执行到这里，都判断instance == null为true时，可能会得到不同的对象
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * Description:懒汉：在方法前面加synchronized，线程安全，但效率低，将并发变为串行
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/12 11:15
     */
    public static synchronized Singleton1 getInstance1() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * Description:懒汉：加同步代码块，减少锁的颗粒大小，效率提升，但依旧线程不安全
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/12 14:05
     */
    public static Singleton1 getInstance3() {
        if (instance == null) {// 若两个线程同时运行到这里，判断instance == null的结果都为true时，则会创建两个不一样的实例
            synchronized (Singleton1.class) {
                instance = new Singleton1();
            }
        }
        return instance;
    }
    
    /**
     * Description:懒汉：加同步代码块，进行双重校验，且使用volatile关键字避免instance = new Singleton1()发生指令重排。
     *                  instance = new Singleton2()其实可以分为下面的步骤：
     *                  1.申请一块内存空间；
     *                  2.在这块空间里实例化对象；
     *                  3.instance的引用指向这块空间地址；
     *                  对于以上步骤，指令重排序很有可能不是按上面123步骤依次执行的。比如，先执行1申请一块内存空间，然后执行3步骤，
     *                  instance的引用去指向刚刚申请的内存空间地址，那么，当它再去执行2步骤，判断instance时，由于instance已经指向了某一地址，
     *                  它就不会再为null了，因此，也就不会实例化对象了。
     * @auther: renyang
     * @param:
     * @return: 
     * @date: 2019/8/12 14:15
     */
    public static Singleton1 getInstance4() {
        if (instance1 == null) {// 若不使用volatile防止指令重排，可能会返回一个引用地址，但实际上对象可能尚未实例化
            synchronized (Singleton1.class) {
                if (instance1 == null) {
                    instance1 = new Singleton1();
                }
            }
        }
        return instance1;
    }

    /**
     * Description: 饿汉：线程安全，实例对象在类装载时就完成了初始化
     * @auther: renyang
     * @param: 
     * @return: 
     * @date: 2019/8/12 13:55
     */
    public static Singleton1 getInstance5() {
        return instance2;
    }
    
    public void testGetInstance() {
        ExecutorService theadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            theadPool.execute(() -> System.out.println(Thread.currentThread().getName() + ":" + Singleton1.getInstance()) );
        }
        theadPool.shutdown();
    }

    public void testGetInstance1() {
        ExecutorService theadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            theadPool.execute(() -> System.out.println(Thread.currentThread().getName() + ":" + Singleton1.getInstance1()) );
        }
        theadPool.shutdown();
    }

    public void testGetInstance5() {
        ExecutorService theadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            theadPool.execute(() -> System.out.println(Thread.currentThread().getName() + ":" + Singleton1.getInstance5()) );
        }
        theadPool.shutdown();
    }

    public static void main(String[] args) {
//        new Singleton1().testGetInstance();// 执行多次，就会发现有不一样的Singleton1对象被创建
//        new Singleton1().testGetInstance1();// 始终返回同一个实例对象
        new Singleton1().testGetInstance5();// 始终返回同一个实例对象
    }

}
