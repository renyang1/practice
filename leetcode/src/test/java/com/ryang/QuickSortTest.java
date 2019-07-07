package com.ryang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: renyang
 * @Date: 2019/1/15 17:01
 * @Description:
 */
public class QuickSortTest {

    private static final int[] arrays = { 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 17, 17, 177, 18, 8, 8, 19};

    @Test
    public void sort() throws Exception {

        new QuickSort().sort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }

}