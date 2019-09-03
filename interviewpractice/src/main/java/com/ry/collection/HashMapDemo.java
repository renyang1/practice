package com.ry.collection;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Auther: renyang
 * @Date: 2019/8/15 11:13
 * @Description:
 */
public class HashMapDemo {

    private HashMap<String, String> map = new HashMap<>();

    @Test
    public void put() {
        String res = map.put("1", "ryang");
        System.out.println(res);
        res = map.put("1", "ryang1");
        System.out.println(res);
    }

    public void creat() {
        HashMap<String, String> hashMap = new HashMap<>(30);
        hashMap.put("key1", "1");
        System.out.println(hashMap.size());
    }
}
