package com.ryang.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-09-20
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.ryang.reflection.Dog");

        /** 获取类的名字 */
        System.out.println("======Name======");
        // 包名+类名
        System.out.println(c1.getName());
        // 类名
        System.out.println(c1.getSimpleName());

        /** 获取类的属性(无法获取父类属性) */
        System.out.println("\r\n" + "======Field======");
        // 只能找到public属性
        Field[] fields = c1.getFields();
        Stream.of(fields).forEach(field ->
                System.out.println("Field " + field)
        );
        // 找到全部属性
        fields = c1.getDeclaredFields();
        Stream.of(fields).forEach(field ->
                System.out.println("DeclaredField " + field)
        );
        // 获得指定属性的值
        System.out.println(c1.getDeclaredField("org"));

        /** 获取类的方法 */
        System.out.println("\r\n" + "======Method======");
        // 获得本类及父类的全部public方法
        Method[] methods = c1.getMethods();
        Stream.of(methods).forEach(method ->
                System.out.println("Method " + method)
        );
        // 获取本类所有方法
        methods = c1.getDeclaredMethods();
        Stream.of(methods).forEach(method ->
                System.out.println("DeclaredMethod " + method)
        );

        // 获得指定方法，因为重载的原因，需要指定方法的参数类型
        Method m1 = c1.getDeclaredMethod("setOrg", String.class);
        System.out.println("setOrg  " + m1);
    }

}
