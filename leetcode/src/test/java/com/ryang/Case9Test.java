package com.ryang;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/11/28 11:13
 * @Description:
 */
public class Case9Test {

    private Case9 case9 = new Case9();
    int x = 121;

    @Test
    public void isPalindrome() throws Exception {
        boolean result = case9.isPalindrome(x);
        System.out.println(result);
    }

    @Test
    public void isPalindrome1() throws Exception {
        boolean result = case9.isPalindrome1(x);
        System.out.println(result);
        String s = "111";
        s.length();
    }
}