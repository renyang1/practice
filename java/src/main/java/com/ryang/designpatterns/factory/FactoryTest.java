package com.ryang.designpatterns.factory;

import com.ryang.designpatterns.factory.abstractfactory.CarFactory1;
import com.ryang.designpatterns.factory.abstractfactory.FruitFactory1;
import com.ryang.designpatterns.factory.abstractfactory.ProductFactory1;
import com.ryang.designpatterns.factory.entity.Car;
import com.ryang.designpatterns.factory.entity.Fruit;
import com.ryang.designpatterns.factory.entity.Product;
import com.ryang.designpatterns.factory.factorymethod.CarFactory;
import com.ryang.designpatterns.factory.factorymethod.FruitFactory;
import com.ryang.designpatterns.factory.factorymethod.ProductFactory;
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

    @Test
    public void factoryMethodTest() {
        ProductFactory carFactory = new CarFactory();
        carFactory.getProduct();

        ProductFactory fruitFactory = new FruitFactory();
        fruitFactory.getProduct();
    }

    @Test
    public void abstractFactoryTest() {
        ProductFactory1 carFactory = new CarFactory1();
        carFactory.getProduct();
        carFactory.getDiscountProduct();

        ProductFactory1 fruitFactory = new FruitFactory1();
        fruitFactory.getProduct();
        fruitFactory.getDiscountProduct();
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
