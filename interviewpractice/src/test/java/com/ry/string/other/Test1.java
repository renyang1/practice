package com.ry.string.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: renyang
 * @Date: 2018/5/30 16:02
 * @Description:
 */
public class Test1 {

    @Test
    public void fun1(){
        List<String> stringList = new ArrayList<>(Arrays.asList("a","b","c","d"));
        for (int i = 0; i < stringList.size(); i++ ) {
            stringList.remove(i);
        }
        System.out.println(stringList);
    }
}
