package com.ryang.leetcode;

/**
 * @Auther: renyang
 * @Date: 2019/1/4 10:17
 * @Description: 给定一个字符串s，找到s中最长的回文子串(正读反读都一样)。你可以假设s的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Case5 {

    public String longestPalindrome(String s) {
        String result = "";
        int firstIndex = 0;
        int lastIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            lastIndex = s.lastIndexOf(chars[i]);
        }
        return null;
    }
}
