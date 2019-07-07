package com.ryang;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/1/15 17:58
 * @Description:
 */
public class HalfSearchTest {

    int arrays[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};

    @Test
    public void search() throws Exception {
        int index = new HalfSearch().search(arrays, 3);
        System.out.println(index);
    }

    @Test
    public void recursiveSearch() throws Exception {
        int index = new HalfSearch().recursiveSearch(arrays, 0, arrays.length-1, 11);
        System.out.println(index);
    }

}