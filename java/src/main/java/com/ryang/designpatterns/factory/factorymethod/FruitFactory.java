package com.ryang.designpatterns.factory.factorymethod;

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
public class FruitFactory implements ProductFactory {

    @Override
    public Product getProduct() {
        System.out.println("product:Fruit");
        return new Fruit();
    }
}


