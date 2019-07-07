package com.ry.chapter2;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/10/10 20:24
 * @Description:
 */
public class Item1Test {
    @Test
    public void getInstance() throws Exception {

        Item1 item1 = Item1.getInstance();
        Item1 item2 = Item1.getInstance();
        System.out.println(item1 == item2);
    }

}