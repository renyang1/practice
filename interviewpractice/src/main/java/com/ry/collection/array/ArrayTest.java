package com.ry.collection.array;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: renyang
 * @Date: 2018/7/16 19:33
 * @Description:
 */
public class ArrayTest {

    /*
     *测试用
     * */
    @Test
    public void testarrayCopy(){
        String[] src = new String[]{"a", "b", "c", "d", "e"};//原数组
        String[] dest = new String[10];
        System.arraycopy(src, 0, dest, 0, 3);
        List<String> s = new ArrayList<>(Arrays.asList(dest));
        System.out.println(s);
    }





}
