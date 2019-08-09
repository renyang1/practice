package com.ry.suanfa.jianzhioffer;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: renyang
 * @Date: 2019/8/9 09:35
 * @Description: 第一个只出现一次的字符
 *               在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 *               如果没有则返回 -1（需要区分大小写）.
 */
public class Case1 {
    private String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
    public int FirstNotRepeatingChar(String str) {
        char[] resChars = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char resChar : resChars) {
            if (map.get(resChar) == null) {// 说明该字符已经出现过
                map.put(resChar, 1);
            }else {
                map.put(resChar, 2);
            }
        }

        Character res = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }

        if (res == null) {
            return -1;
        }else {// 查找位置
            int index = str.indexOf(res);
            return index;
        }
    }

    @Test
    public void test() {
        Case1 case1 = new Case1();
        int index = case1.FirstNotRepeatingChar(str);
        System.out.println(index);
    }
}
