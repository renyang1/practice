package com.ry.chapter2;

/**
 * @Auther: renyang
 * @Date: 2018/10/10 20:03
 * @Description: 第一条建议：用静态工厂方法代替构造器
 */
public class Item1 {

    private static Item1 item1 = new Item1();

    public String itemName;

    public static Item1 getInstance(){
        return item1;
    }
}
