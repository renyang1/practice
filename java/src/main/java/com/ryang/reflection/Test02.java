package com.ryang.reflection;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-09-20
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Test02 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }


}

class A {

    // 静态代码块和静态变量按在类中的申明顺序依次加载
    static int m = 100;

    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    static {
        System.out.println("A类静态代码块初始化");
        m = 200;
    }

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}
