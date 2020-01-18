package com.ryang;

import org.junit.Test;

/**
 * @author renyang
 * @date: 2019/10/14 14:31
 * des:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Case394 {
    public String decodeString(String s) {
        // 字符串中最后的一个[字符的位置
        int a = s.lastIndexOf("[");
        // 字符串中最后一个]的位置
        int b = s.indexOf("]", a);
        while (a > -1 && b > -1){
            // 获取重复的次数
            String timeString = "";
            for (int i = a -1; i >= 0; i--){
                if (s.substring(i, i + 1).equals("]")){
                    break;
                }
                timeString = timeString + s.substring(i, i + 1);
            }
            int times = Integer.valueOf(timeString);
            // []中需要重复的字符串
            String target = s.substring(a + 1, b);
            for (int i = 1; i < times; i++) {
                target = target + s.substring(a + 1, b);
            }
            // 将k[]替换为转换后的字符串
            StringBuffer sb = new StringBuffer(s);
            sb.replace(a- 1, b+1, target);
            s = sb.toString();
            // 判断结果中是否还存在需要替换的字符串
            a = s.lastIndexOf("[");
            b = s.indexOf("]", a);
        }
        return s;
    }

    @Test
    public void test() {
        String s = "3[a2[c]]";
//        System.out.println(s.substring(0,1));
        System.out.println(decodeString(s));
    }
}
