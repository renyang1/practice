package com.ryang.leetcode;

/**
 * @Auther: renyang
 * @Date: 2018/11/29 20:43
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Case14 {

    public String longestCommonPrefix(String[] strs) {

        // 空判断
        if (strs.length <= 0) {
            return "";
        }

        // 数组长度为1时，直接返回第一个字符串
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder builder = new StringBuilder();
        int firstStringLength = strs[0].length();
        for (int i = 0; i < firstStringLength; i++) {
            char firstStringChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                /*临界条件：
                * 1.当第一个字符串后面任一字符串的长度小于第一个字符串当前下标时，结束
                * 2.当第一个字符串后面任一字符串与第一个字符串当前相同位置字节值不一样时，结束
                * */
                if (strs[j].length() <= i || strs[j].charAt(i) != firstStringChar) {
                    return builder.toString();
                }
                // 当字符串数组最后一个字符串相同位置与第一个字符串的相同位置字节相同时，该字节为公共前缀
                if (j == strs.length - 1 && strs[j].charAt(i) == firstStringChar) {
                    builder.append(firstStringChar);
                }

            }
        }
        return builder.toString();
    }
}
