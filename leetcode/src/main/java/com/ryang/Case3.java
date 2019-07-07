package com.ryang;

/**
 * @Auther: renyang
 * @Date: 2019/1/3 11:42
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:解决思路：从第一个字符到最后一个字符，分别取无重复字符子串组合进行比较子串长度，取最大长度
 *             如：字符串为abca，则有abc、bca、ca三种组合，再取最长的字串长度返回
 * @auther: renyang
 * @param:
 * @return:
 * @date: 2019/1/3 14:56
 */
public class Case3 {
    
    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        char[] aimChars = s.toCharArray();
        for (int i = 0; i < aimChars.length; i++) {
            StringBuffer sBuffer = new StringBuffer();
            for (int j = i; j < aimChars.length; j++) {
                if (sBuffer.toString().contains(String.valueOf(aimChars[j]))) {
                    break;
                } else {
                    sBuffer.append(aimChars[j]);
                }
                if (sBuffer.length() > result)
                    result = sBuffer.length();
            }
        }
        return result;
    }

    /**
     * Description:滑动窗口
     *              将[i,j)区间的字符串当作一个窗口，并将窗口字符串存储在Set中，
     *              i,j分别为左右边界，窗口向右进行滑动来取不同的子串
     * @auther: renyang
     * @param:
     * @return: 
     * @date: 2019/1/3 19:50
     */
    public int lengthOfLongestSubstring2(String s) {

        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                // 当前窗口不包含有边界当前对应字符，将有边界当前对应字符放进窗口字符串，并将右边界向右移动1
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }else {
                // 将窗口左边界向右移动1，直到不包含右边界当前对应字符
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    /**
     * Description:优化窗口
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/3 20:21
     */
    public int lengthOfLongestSubstring3(String s) {

        // 存放字符及其在字符串中的索引值
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        // i为左边界值，j为右边界值
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                // 若map中包含当前字符，则移动左边界位置,保证字符串中从左边界(i)到右边界(j)之间无重复字符
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            result = Math.max((j - i + 1), result);
        }
        return result;
    }
}
