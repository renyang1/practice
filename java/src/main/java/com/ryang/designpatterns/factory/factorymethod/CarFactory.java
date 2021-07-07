package com.ryang.designpatterns.factory.factorymethod;

import com.ryang.designpatterns.factory.entity.Car;
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
public class CarFactory implements ProductFactory {

    @Override
    public Product getProduct() {
        System.out.println("product:Car");
       return new Car();
    }
}
