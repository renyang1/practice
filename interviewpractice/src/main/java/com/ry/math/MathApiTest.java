package com.ry.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Auther: renyang
 * @Date: 2019/4/22 11:34
 * @Description: Math类计算相关api使用
 */
public class MathApiTest {

    @Test
    public void testPow(){

        double a = 4;
        double b = 1.7;
        double c = Math.pow(a,b);
        System.out.println(c);
        BigDecimal d = BigDecimal.valueOf(c).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(d);
    }
}
