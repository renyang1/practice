package com.ry.suanfa;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/19 20:24
 * @Description: 求相反数：我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"
 *                        例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,
 *                        我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1
 */
public class Case3 {

    private final int resource = 1325;

    public int getReverseNumber(int resource) {
        // 1.将数字转换为字符串再反转，注意StringBuffer的构造函数，若使用数字做为构造函数参数，则表示缓冲区的大小，
        //   使用字符串才能构造出此字符串内容的字符串缓冲区
        String reverse = new StringBuffer(String.valueOf(resource)).reverse().toString();
        // 2.将反转后得到的值和原值相加得到'相反数'
        return Integer.valueOf(reverse) + resource;
    }

    @Test
    public void test() {
        int reverseNumber = getReverseNumber(resource);
        System.out.println(reverseNumber);
    }
}
