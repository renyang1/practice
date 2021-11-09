package com.ryang;

import com.ryang.leetcode.Case14;
import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/11/29 21:18
 * @Description:
 */
public class Case14Test {

    private Case14 case14 = new Case14();
    @Test
    public void longestCommonPrefix() throws Exception {
//        String[] strs = new String[]{"dog","racecar","car"};
//        String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{};
        String result = case14.longestCommonPrefix(strs);
        System.out.println(result);
    }

}