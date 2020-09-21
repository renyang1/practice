package com.ryang.reflection;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-09-20
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Test05 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.ryang.reflection.Student");

        // 通过反射获取类上注解
        Annotation[] annotations = c1.getAnnotations();
        Stream.of(annotations).forEach(annotation ->
                System.out.println(annotation)
        );

        // 获得注解的值
        RyTable ryTable = (RyTable) c1.getAnnotation(RyTable.class);
        System.out.println(ryTable.value());

        // 获得属性的注解
        Field id = c1.getDeclaredField("id");
        RyColumn ryColumn = id.getAnnotation(RyColumn.class);
        System.out.println(ryColumn.columnName());
        System.out.println(ryColumn.type());
        System.out.println(ryColumn.length());
    }

}

@Data
@RyTable("user")
class Student {

    @RyColumn(columnName = "id", type = "int", length = 2)
    private int id;

    @RyColumn(columnName = "name", type = "varchar", length = 20)
    private String name;
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface RyTable {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface RyColumn {
    String columnName();

    String type();

    int length();
}