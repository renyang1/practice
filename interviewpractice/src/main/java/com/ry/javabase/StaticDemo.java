package com.ry.javabase;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/22 23:20
 * @Description: 问题：A a = new B();
 *                    B b = new B();会输出什么？
 *               本题考查对象初始化是静态代码块、构造方法的执行顺序。需要注意静态代码块只会执行一次
 */
public class StaticDemo {

    @Test
    public void test() {
        A a = new B();
        B b = new B();
    }
}

class A {
    public A() {
        System.out.println("A构造方法调用");
    }

    static {
        System.out.println("A静态代码块调用");
    }
}

class B extends A {
    public B() {
        System.out.println("B构造方法调用");
    }

    static {
        System.out.println("B静态代码块调用");
    }
}