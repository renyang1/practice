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
public class Product {

    protected String name;

    protected Integer price;

    protected String type;

    public void detail(){}

}
