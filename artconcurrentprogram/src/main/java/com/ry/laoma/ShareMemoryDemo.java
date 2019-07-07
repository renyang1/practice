package com.ry.laoma;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: renyang
 * @Date: 2018/7/16 20:02
 * @Description: 多线程中的共享内存及问题
 * */

public class ShareMemoryDemo {

    public static int shared = 0;//共享变量shared

    public void incrShared(){
        shared++;
    }

    @Test
    public void testShareMemoryDemo() throws Exception{
        List<String> list = new ArrayList<>();//共享变量list
        ShareMemoryDemo shareMemoryDemo = new ShareMemoryDemo();
        SharedThread sharedThread = new SharedThread(list, shareMemoryDemo);
        Thread t1 = new Thread(sharedThread);
        Thread t2 = new Thread(sharedThread);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(ShareMemoryDemo.shared);
        System.out.println(list);
        /*
         * 可能输出结果
         * 2  [null, Thread-0]
         * 2  [null, Thread-1]
         * 当两个线程都持有空对象的list引用时，一个线程改变了list中的值，另一个线程没有读取到变化后的值，
         * 依旧在持有的空对象上做add操作，会造成这种结果
         */
    }
}

class SharedThread implements Runnable{
    List<String> list;
    ShareMemoryDemo shareMemoryDemo;

    public SharedThread(List<String> list, ShareMemoryDemo shareMemoryDemo) {
        this.list = list;
        this.shareMemoryDemo = shareMemoryDemo;
    }

    @Override
    public void run() {
        shareMemoryDemo.incrShared();
        list.add(Thread.currentThread().getName());
    }
}
