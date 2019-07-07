package com.ry.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: renyang
 * @Date: 2018/6/2 17:31
 * @Description: 处理javaBean对象的工具类
 */
public class BeanUtils {

    /**
     * Description: 将JavaBean对象的属性转换为map的数据结构
     * @auther: renyang
     * @param: Object，需要进行转换的对象
     * @return: Map<String, Object>，转换后的map对象，key为属性值，value为属性值
     * @date: 2018/6/2 18:15
     */
    public static Map<String, Object> describe(Object obj){
        Map<String, Object> proMap = new HashMap<>();
        try{
            //1.获得Bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            //2.获得属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            //3.遍历所有属性
            for (PropertyDescriptor descriptor : descriptors){
                //属性名称
                String name = descriptor.getName();
                //读取该属性的方法
                Method gettetMethod = descriptor.getReadMethod();
                //读取值
                Object value = gettetMethod.invoke(obj,new Object[]{});
                if(! name.equalsIgnoreCase("class")){
                    proMap.put(name,value);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return proMap;
    }

    /**
     * Description: 将Map的值返回到Bean对象中
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2018/6/2 18:17
     */
    public static void populate(Object obj, Map<String, Object> propMap){
        try{
            //1.获得bean对象的描述
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            //2.获得属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            //3.遍历所有属性
            for (PropertyDescriptor descriptor: descriptors) {
                //属性名称
                String name = descriptor.getName();
                if(propMap.containsKey(name)){
                    //如果传入方法的集合中有此属性，则写入Bean对象
                    Method setterMethod = descriptor.getWriteMethod();
                    //将值写入对象中
                    setterMethod.invoke(obj,new Object[]{propMap.get(name)});
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
