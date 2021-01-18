package com.ryang.designpatterns.factory;

import com.ryang.designpatterns.entity.Car;
import com.ryang.designpatterns.entity.Fruit;
import com.ryang.designpatterns.entity.Product;
import com.ryang.designpatterns.factory.simplefactory.SimpleProductFactory;
import org.junit.Test;

/**
 * Description: 简单工厂
 *
 * @author renyang
 * @date 2021-01-14
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class FactoryTest {

    @Test
    public void noFactory() {
        Product car = getProductByType("car");
        car.detail();

        Product fruit = getProductByType("fruit");
        fruit.detail();

        Product pen = getProductByType("pen");
        pen.detail();
    }

    @Test
    public void simpleFactory() {
        Product product = SimpleProductFactory.getProduct("car");
        product.detail();
    }

    /**
     * 未使用设计模式获取对象
     *
     * @param type
     * @return
     */
    public static Product getProductByType(String type) {
        switch (type) {
            case "car":
                return new Car("bmw", 100);
            case "fruit":
                return new Fruit("apple", 10);
            default:
                throw new RuntimeException("类型错误");
        }
    }
}
