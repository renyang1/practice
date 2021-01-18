package com.ryang.designpatterns.factory;

import com.ryang.designpatterns.entity.Car;
import com.ryang.designpatterns.entity.Product;
import com.ryang.designpatterns.factory.simplefactory.SimpleProductFactory;
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
    public Product getProduct(String type) {
       return new Car();
    }
}
