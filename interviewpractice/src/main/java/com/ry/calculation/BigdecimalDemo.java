package com.ry.calculation;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Auther: renyang
 * @Date: 2019/8/6 19:25
 * @Description: 使用
 */
public class BigdecimalDemo {

    /**
     * Description: 1. 创建BigDecimal对象
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/6 19:26
     */
    @Test
    public void creat() {

        // 1.使用字符串创建对象【推荐使用此种方式，不会丢失精度】
        BigDecimal bigDecimal1 = new BigDecimal("1.6");
        System.out.println(bigDecimal1);// 1.6

        // 2.使用folat创建对象(会出现精度丢失问题)
        float f = 1.66F;
        BigDecimal bigDecimal2 = new BigDecimal(f);
        System.out.println(bigDecimal2);// 1.65999996662139892578125

        // 3.将float、double类型转换为String再创建
        BigDecimal bigDecimal3 = new BigDecimal(String.valueOf(f));
        System.out.println(bigDecimal3);// 1.66
    }

    /**
     * Description: 2.使用BigDecimal进行计算，注意计算结果需要赋值给一个BigDecimal对象
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/6 19:47
     */
    @Test
    public void calc() {

        BigDecimal bigDecimal1 = new BigDecimal("1.62");
        BigDecimal bigDecimal2 = new BigDecimal("3.64");

        // 1.加法
        BigDecimal addResult = bigDecimal1.add(bigDecimal2);// 注意需要将计算结果赋值给一个新的BigDecimal对象
        System.out.println(addResult);

        // 2.减法
        BigDecimal subResult = bigDecimal1.subtract(bigDecimal2);
        System.out.println(subResult);

        // 3.乘法
        BigDecimal mulResult = bigDecimal1.multiply(bigDecimal2);
        System.out.println(mulResult);

        // 4.除法,一定得指定精度表示到小数点后多少位，否则在不能整除的情况下会出现java.lang.ArithmeticException
        BigDecimal divResult = bigDecimal1.divide(bigDecimal2, 2, BigDecimal.ROUND_HALF_UP);// 设置精度、舍入模式
        System.out.println(divResult);

        // 5.绝对值
        BigDecimal bigDecimal3 = new BigDecimal("-1.5");
        BigDecimal absResult = bigDecimal3.abs();
        System.out.println(absResult);
    }

    /**
     * Description: 3.设置精度:以下为8种舍入模式
     *                  ROUND_UP：舍入远离零的舍入模式，在丢弃非零部分之前始终增加数字(始终对非零舍弃部分前面的数字加1)
     *                  ROUND_DOWN：接近零的舍入模式，在丢弃某部分之前始终不增加数字(从不对舍弃部分前面的数字加1，即截短)
     *                  ROUND_CEILING：接近正无穷大的舍入模式，如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同;如果为负，则舍入行为与 ROUND_DOWN 相同
     *                  ROUND_FLOOR:如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同;如果为负，则舍入行为与 ROUND_UP 相同
     *                  ROUND_HALF_UP:向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式(四舍五入)
     *                  ROUND_HALF_DOWN:向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式(五舍六入)
     *                  ROUND_HALF_EVEN:如果舍弃部分左边的数字为奇数，则舍入行为与 ROUND_HALF_UP 相同；如果为偶数，则舍入行为与 ROUND_HALF_DOWN 相同
     *                  ROUND_UNNECESSARY：断言请求的操作具有精确的结果，因此不需要舍入
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/6 20:44
     */
    @Test
    public void setPrecision() {
        BigDecimal decimal1 = new BigDecimal("1.333333");
        // 设置精度、舍入模式
        decimal1 = decimal1.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal1);
    }
}
