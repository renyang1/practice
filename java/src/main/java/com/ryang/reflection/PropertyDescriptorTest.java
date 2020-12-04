package com.ryang.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-12-04
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class PropertyDescriptorTest {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        DogTest dog = new DogTest("testOrg");
        Object obj = dog;

        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("org", dog.getClass());
        // 获取属性读方法
        Method orgReadMethod = propertyDescriptor.getReadMethod();
        Object object = orgReadMethod.invoke(obj);
        System.out.println(object);

        // 获取属性写方法
        Method orgWriteMethod = propertyDescriptor.getWriteMethod();
        orgWriteMethod.invoke(obj, "testOrg1");
        System.out.println(obj.toString());
    }
}

@Data
@AllArgsConstructor
@ToString
class DogTest {
    private String org;
}