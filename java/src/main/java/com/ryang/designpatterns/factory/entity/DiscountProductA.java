package com.ryang.designpatterns.factory.entity;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-01-21
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class DiscountProductA extends DiscountProduct{

    public DiscountProductA() {}

    public DiscountProductA(String name, Integer price, Integer discountPrice) {
        this.name = name;
        this.price = price;
        this.type = "汽车";
        this.discountPrice = discountPrice;
    }

    @Override
    public void detail() {
        System.out.println("DiscountProductA：" + name);
    }
}
