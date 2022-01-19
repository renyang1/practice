package com.ryang.kyapi.guava;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author 10023991
 */
public class ListsTest {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> partition = Lists.partition(integers, 3);
        for (List<Integer> integerList : partition) {
            System.out.println(integerList);
            integerList.clear();
            System.out.println("原集合integers:" + integers);
        }
    }
}
