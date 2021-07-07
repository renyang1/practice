package com.ryang.designpatterns.factory.abstractfactory;


import com.ryang.designpatterns.factory.entity.DiscountProduct;
import com.ryang.designpatterns.factory.entity.Product;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-01-14
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public interface ProductFactory1 {

    Product getProduct();

    DiscountProduct getDiscountProduct();
}
