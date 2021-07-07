package com.ryang.designpatterns.factory.abstractfactory;

import com.ryang.designpatterns.factory.entity.DiscountProduct;
import com.ryang.designpatterns.factory.entity.DiscountProductB;
import com.ryang.designpatterns.factory.entity.Fruit;
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
public class FruitFactory1 implements ProductFactory1 {

    @Override
    public Product getProduct() {
        System.out.println("create product : Fruit");
        return new Fruit();
    }

    @Override
    public DiscountProduct getDiscountProduct() {
        System.out.println("create product : DiscountProductB");
        return new DiscountProductB();
    }
}


