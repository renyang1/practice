package com.ryang.designpatterns.entity;

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
public class Fruit extends Product {

    private String type = "水果";

    public Fruit() {

    }

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void detail() {
        System.out.println("水果：" + name);
    }
}


