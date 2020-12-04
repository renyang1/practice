package com.ry.javabase;

import lombok.Data;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-10-16
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class ObjectTest {

    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.setName("Aa1");

        A1 a11 = a1;

        Aa1 aa1 = new Aa1();
        aa1.setA1(a1);

        a1 = new A1();
        a1.setName("Aa2");

        Aa2 aa2 = new Aa2();
        aa2.setA1(a1);

        System.out.println(aa1.getA1().getName());
        System.out.println(aa2.getA1().getName());
        aa1.getA1().setName("test");
        System.out.println(a11.getName());
        Object object = (Object) null;
        fun1(object);

    }


    public static void fun1(Object... object) {
        System.out.println(object[0]);
        System.out.println(object.length);
    }
}

@Data
class Aa1 {

    private A1 a1;
    private String name;
}

@Data
class Aa2 {

    private A1 a1;
    private String name;
}

@Data
class A1{
    private String name;
}



