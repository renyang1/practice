package com.ryang.bf.bfjczs;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/5/6 17:53
 * @Description:
 */
public class Case68_1Test {

    @Test
    public void startAtSameTime() throws Exception{
        new Case68_1().startAtSameTime();
    }

    @Test
    public void fun1() {
        double d = 0.342d;
        long l = Double.doubleToLongBits(d);
        System.out.println(l);
        double d1 = Double.longBitsToDouble(l);
        System.out.println(d1);
    }
}