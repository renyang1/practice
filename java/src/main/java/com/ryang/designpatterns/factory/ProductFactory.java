package com.ryang.designpatterns.factory;

import com.ryang.designpatterns.entity.Product;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-01-14
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public interface ProductFactory {

    Product getProduct(String type);
}
