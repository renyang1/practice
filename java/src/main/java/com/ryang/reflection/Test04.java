package com.ryang.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-09-20
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Test04 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 获得Class对象
        Class c1 = Class.forName("com.ryang.reflection.Dog");

        // 构造对象
        Dog dog = (Dog) c1.newInstance();
        System.out.println(dog);

        /** 通过反射操作方法 */
        // 获取方法
        Method setOrg = c1.getDeclaredMethod("setOrg", String.class);
        setOrg.invoke(dog, "大南高");
        System.out.println(dog.getOrg());

        /** 通过反射操作属性 */
        Dog dog1 = (Dog) c1.newInstance();
        System.out.println(dog1);
        // 获取属性
        Field org = c1.getDeclaredField("org");
        // 不能直接操作私有属性，需要调用属性或方法的setAccessible(true)关闭安全检测
        org.setAccessible(true);
        org.set(dog1, "南充");
        System.out.println(dog1.getOrg());
    }
}
