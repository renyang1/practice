package com.ryang.bf.bfrql;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther: renyang
 * @Date: 2019/5/16 16:51
 * @Description: 并发容器CopyOnWriteArrayList类
 */
public class Case73_1 {

    public static void main(String[] args) {
        // 同步容器
        // final List<String> list = Collections.synchronizedList(new ArrayList<>());

        // 并发容器
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // 集合赋值
        for (int i = 0; i < 100; i++) {
            list.add("item" + i);
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        startIteratorThread(list);
        startModifyThread(list);
    }

    /**
     * Description:启动一个线程对集合进行修改操作
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/5/16 20:02
     */
    public static void startModifyThread(List<String> list) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add("add item" + i);
//                try {
//                    Thread.sleep((long) (Math.random() * 10));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
    }

    /**
     * Description:启动一个线程对集合进行遍历操作
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/5/16 20:06
     */
    public static void startIteratorThread(final List<String> list) {
        new Thread(() -> {
            // 这里只会输出旧数组的值，因为这里的本质是迭代器，而迭代器对象创建时是以旧数组为对象创建的，
            // 该数组不会随着集合的变化而变化
//            for (String s : list) {
//                System.out.println(s);
//                try {
//                    Thread.sleep((long) (Math.random() * 10));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            // 迭代器
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
