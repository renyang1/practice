package com.ry;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/8/12 14:55
 * @Description:
 */
public class StaticTest {

    static {
        i = 2;
        //System.out.println(i);//这里访问会报错
    }
    static int i = 3;

    @Test
    public void test1(){
        System.out.println(StaticTest.i);//i的值为3，按代码顺序，值为后赋值的结果
    }
}
