package com.ryang.reflection;

import lombok.Data;

import java.time.Period;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-09-20
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Person();

        // 1.通过对象获取
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // 2.forName获取
        Class c2 = Class.forName("com.ryang.reflection.Person");
        System.out.println(c2.hashCode());

        // 3.类名.class获取
        Class c3 = Person.class;
        System.out.println(c3.hashCode());
     }
}

@Data
class Person {
    private String name;
    private int age;
}
