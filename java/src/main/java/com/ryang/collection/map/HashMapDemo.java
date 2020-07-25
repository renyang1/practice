package com.ryang.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-03-26
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class HashMapDemo {

    @Test
    public void test1() {
        Map<String,String> map1 = new HashMap<>(12);
        System.out.println(map1.size());
    }
}
