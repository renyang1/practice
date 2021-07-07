package com.ryang.designpatterns.factory.abstractfactory;

import com.ryang.designpatterns.factory.entity.Car;
import com.ryang.designpatterns.factory.entity.DiscountProduct;
import com.ryang.designpatterns.factory.entity.DiscountProductA;
import com.ryang.designpatterns.factory.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-01-14
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
@Data
@AllArgsConstructor
public class CarFactory1 implements ProductFactory1 {

    @Override
    public Product getProduct() {
       System.out.println("create product : Car");
       return new Car();
    }

    @Override
    public DiscountProduct getDiscountProduct() {
        System.out.println("create product : DiscountProductA");
        return new DiscountProductA();
    }
}
