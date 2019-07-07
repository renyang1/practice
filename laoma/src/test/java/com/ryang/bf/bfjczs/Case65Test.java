package com.ryang.bf.bfjczs;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/4/30 17:14
 * @Description:
 */
public class Case65Test {

    @Test
    public void incrShared() throws Exception {
        Case65 case65 = new Case65();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                case65.incrShared();
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(case65.shared);
    }

    @Test
    public void visibility() throws Exception {
        Case65 case65 = new Case65();
        new Thread(() -> {
            case65.visibility();
        }).start();
        Thread.sleep(500);
        Case65.shutDown = true;
        System.out.println("exit main!");
    }
}