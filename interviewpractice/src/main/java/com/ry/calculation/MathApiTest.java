package com.ry.calculation;

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

    @Test
    public void testRound() {
        // round函数运算规则：对目标数进行四舍五入计算
        // 四舍五入：对目标数加0.5后再向下取整
        // 向下取整：当计算的结果不为整数时取小于计算结果的整数.当计算结果为整数时直接取整数
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
    }
}
