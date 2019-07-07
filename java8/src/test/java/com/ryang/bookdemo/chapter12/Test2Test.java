package com.ryang.bookdemo.chapter12;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/1/2 17:55
 * @Description:
 */
public class Test2Test {

    Test2 test2 = new Test2();

    @Test
    public void test() {
        test2.method2();
    }

    @Test
    public void test2() {
        String s = "dddsc";
        int[] map = new int[256];
        int j = 0, max = 0, count = 0;
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length() && count == 0) {
                if (map[s.charAt(j++)]++ > 0) count++;
                if (count == 0 && j - i > max) max = j - i;
            }

            if (--map[s.charAt(i)] == 1) count--;
        }

        System.out.println(max);

    }
}