package com.ry.string;

import java.util.Date;

/**
 * @Auther: renyang
 * @Date: 2018/6/5 18:15
 * @Description:
 */
public class StaticDispatch {

    public static void main(String[] args) {
        staticDispatchMethod();

    }

    public void sayHello(Animal animal){
        animal.sayHello();
    }

    public void sayHello(Dog dog){
        dog.sayHello();
    }

    /**
     * Description: 测试在java重载中的静态分派
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2018/6/5 18:19
     */
    public static void staticDispatchMethod(){
        Animal dog = new Dog();
        Dog dog1 = new Dog();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(dog);
        staticDispatch.sayHello(dog1);
    }
}
