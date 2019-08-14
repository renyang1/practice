package com.ry.string;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/14 20:39
 * @Description: String一些常用API的使用
 */
public class StringDemo {

    /**
     * Description: 实现字符串大小写的相互转换
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/14 20:47
     */
    @Test
    public void littleToBig() {
        String s = "adss";
        s = s.toUpperCase();
        System.out.println(s);
        s = s.toLowerCase();
        System.out.println(s);
    }

}
