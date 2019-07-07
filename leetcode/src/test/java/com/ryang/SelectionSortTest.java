package com.ryang;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/1/13 18:10
 * @Description:
 */
public class SelectionSortTest {

    private static final int[] arr = {1,3,2,45,65,33,12};

    @Test
    public void sort() throws Exception {
        new SelectionSort().sort(arr);
    }

}