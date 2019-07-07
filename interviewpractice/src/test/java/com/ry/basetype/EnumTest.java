package com.ry.basetype;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/7/3 19:04
 * @Description: 枚举类测试类
 */
public class EnumTest {

    @Test
    public void fun1(){
        int colorCode = 1;
        String name = ColorEnum.getName(colorCode);
        System.out.println(name);
    }

}
