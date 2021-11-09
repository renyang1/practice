package com.ryang.leetcode.leetcode_202107;

import java.util.HashMap;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
public class Case_125 {

    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();

        // 将字符串中的数字、字符找出
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            // 判断字符是否为数字或字符
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }

        // 双指针，判断左右是否相等
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(10);
        System.out.println(hashMap.size());
        int[] a = new int[10];
        System.out.println(new Case_125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
