package com.ryang.bookdemo.chapter12;

/**
 * @Auther: renyang
 * @Date: 2019/1/2 17:51
 * @Description:
 */
public abstract class Test1 {

    public abstract String method1();

    public void method2() {
        System.out.println("调用抽象方法，输出值为：" + method1());
    }
}
