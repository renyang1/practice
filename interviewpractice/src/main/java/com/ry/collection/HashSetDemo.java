package com.ry.collection;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Auther: renyang
 * @Date: 2019/8/15 10:24
 * @Description: HashSet相关使用
 */
public class HashSetDemo {
    private HashSet<String> set = new HashSet();

    @Test
    public void add() {
        boolean res = set.add("ryang");
        System.out.println(res);
        res = set.add("ryang");
        System.out.println(res);
    }
}
