package com.ry.suanfa;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/24 16:35
 * @Description: 有以下数列：1，1，2，3，5，8，13...，先需要输入一个数，得到对应的结果。
 *               如输入4，返回3
 */
public class Case5 {

    @Test
    public void test() {
        int result = calc(1);
        System.out.println(result);
    }

    public int calc(int index) {
        if (index == 1 || index == 2) {
            return 1;
        }else {
            return calc(index -1) + calc(index - 2);
        }
    }
}
