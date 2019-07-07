package com.ry.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: renyang
 * @Date: 2018/7/16 19:12
 * @Description: 该类用于测试List相关的维问题，包括学习源码的一些验证等
 */
public class ArrayListTest {

    @Test
    public void removeTest(){
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        for (String string: strings) {
            if("b".equalsIgnoreCase(string)){
                strings.remove(string);
            }
        }
        System.out.println(strings);
    }

}
