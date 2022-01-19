package com.ryang.designpatterns.template;

public abstract class AbstractClass {

    /**
     * 模版方法算法核心类，定义算法的步骤，函数定义为final是为了避免子类重写该方法改变算法框架
     */
    public final void templateMethod() {
        step1();
        step1();
    }

    /**
     * 方法定义为抽象,子类必须重写实现自己的逻辑
     */
    protected abstract void step1();

    /**
     * 该方法非抽象方法，子类可以选择是否进行实现
     */
    protected void step2() {
        // doSomething
    }
}
