package com.ry.suanfa;

/**
 * @Auther: renyang
 * @Date: 2019/2/15 17:21
 * @Description: 将A字符串中的B字符串进行反转
 *               如：A: "asc(uube07beitc", B: "be"
 *               则输出： "asc(uueb07ebitc"
 *               */
public class ReversalPortionString {

    /**
     * Description: 将原字符串中的目标字符串进行反转
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/2/15 17:55
     */
    public String reversalPortionString(String original, String targetString) {
        return original.replaceAll(targetString, reversalString(targetString));
    }

    /**
     * Description: 反转参数传入的字符串
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/2/15 17:54
     */
    public String reversalString(String targetString) {

        StringBuilder sBuilder = new StringBuilder(targetString);
        return sBuilder.reverse().toString();
    }

}
