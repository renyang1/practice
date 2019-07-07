package com.ryang.bf.bfjczs;

/**
 * @Auther: renyang
 * @Date: 2019/4/30 16:04
 * @Description: (65) 线程的基本概念 / 计算机程序的思维逻辑
 */
public class Case65 {
    public static int shared = 0;
    public static boolean shutDown = false;


    public void incrShared() {
        try {
            Thread.sleep((int) Math.random() * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10000; i++) {
            shared++;
        }
    }

    /**
     * Description:测试多线程内存可见性方法
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/4/30 17:20
     */
    public void visibility(){

            while (!shutDown){
                // do nothing
                System.out.println("hello...");
            }
            System.out.println("bye bye ryang!");
        }
}
