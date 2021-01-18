package com.ryang.designpatterns.factory.simplefactory;

import com.ryang.designpatterns.entity.Car;
import com.ryang.designpatterns.entity.Fruit;
import com.ryang.designpatterns.entity.Product;

/**
 * Description: 简单工厂方法模式
 *
 * @author renyang
 * @date 2021-01-14
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class SimpleProductFactory {

    /**
     * 使用简单方法工厂获取对象
     *
     * @param type
     * @return
     */
    public static Product getProduct(String type) {
        switch (type) {
            case "car" :
                return new Car("bmw", 100);
            case "fruit" :
                return new Fruit("apple", 10);
            default: throw new RuntimeException("类型错误");
        }
    }
}
