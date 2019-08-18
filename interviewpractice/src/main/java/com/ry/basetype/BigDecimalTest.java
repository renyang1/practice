package com.ry.basetype;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Auther: renyang
 * @Date: 2018/6/15 13:28
 * @Description:
 */
public class BigDecimalTest {

    @Test
    public void fun1(){
        BigDecimal b1 = new BigDecimal("1.000");
        BigDecimal b2  = new BigDecimal("2.222");
        BigDecimal b3 = b1.add(b2);
        b3 = b3.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(b3);
    }

    @Test
    public void test() {
        float x = 0F;
        if (x == 0) {
            System.out.println("00000");
        }

    }
}
