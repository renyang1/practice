package com.ryang.designpatterns.factory.entity;

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
public class Car extends Product {

    public Car() {

    }

    public Car(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.type = "汽车";
    }

    @Override
    public void detail() {
        System.out.println("汽车：" + name);
    }
}
