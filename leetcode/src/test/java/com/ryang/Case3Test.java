package com.ryang;

import com.ryang.leetcode.Case3;
import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/1/3 14:08
 * @Description:
 */
public class Case3Test {

    String aimString = "tmmzuxt";

    @Test
    public void lengthOfLongestSubstring() throws Exception {

        System.out.println(new Case3().lengthOfLongestSubstring(aimString));
    }

    @Test
    public void lengthOfLongestSubstring2() throws Exception {
        System.out.println(new Case3().lengthOfLongestSubstring2(aimString));
    }

    @Test
    public void lengthOfLongestSubstring3() throws Exception {
        System.out.println(new Case3().lengthOfLongestSubstring3(aimString));
    }
}