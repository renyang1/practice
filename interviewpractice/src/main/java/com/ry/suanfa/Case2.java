package com.ry.suanfa;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: renyang
 * @Date: 2019/4/24 10:18
 * @Description:
 * 一个字符串 abcddcba 写一个代码证明 这个字符串是对称的
 */
public class Case2 {
    public boolean stringIsSymmetry(String source){

        if (StringUtils.isBlank(source)){
            throw new RuntimeException("输入的值不能为空！");
        }

        boolean isSymmetry = false;
        if (source.length() % 2 != 0){// 字符串长度值为奇数时，不对称
            return isSymmetry;
        }

        // 将字符串从中间截断为两部分
        String s1 = source.substring(0,source.length()/2);// 前半部
        String s2 = source.substring(source.length()/2);// 后半部
        StringBuffer sb = new StringBuffer(s2);
        s2 = sb.reverse().toString();
        isSymmetry = StringUtils.equals(s1,s2);
        return isSymmetry;
    }
}