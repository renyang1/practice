package com.ry.suanfa.jianzhioffer;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/15 11:59
 * @Description:  将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 *                要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Case3 {

    private String resource = "-12312312sa";

    public void conversion(String resource) {
        StringBuilder sb = new StringBuilder();
        char[] resourceChars = resource.toCharArray();
        int start = 0;
        String firstChar = String.valueOf(resourceChars[0]);
        if ("+".equals(firstChar) || "-".equals(firstChar)) {// 首个字符是否为符号位
            start = 1;
            sb.append(firstChar);
        }else {
            sb.append("0");
        }

        for (int i = start; i < resourceChars.length; i++) {
            if (Character.isDigit(resourceChars[i])) {// 调用Character.isDigit(char)方法判断是否是数字，是返回True，否则False
                sb.append(resourceChars[i]);
            }else {
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test() {
        conversion(resource);
    }
}
