package com.ry.suanfa.jianzhioffer;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/15 11:35
 * @Description: 将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Case2 {

    private String resource = "We Are Happy";

    /**
     * Description:使用String的API直接替换
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/15 11:41
     */
    public void replaceSpace(String resource) {
        resource = resource.replaceAll(" ", "%20");
        System.out.println(resource);
    }

    /**
     * Description:将字符串转为字符，再判断字符是否为空，为空则进行替换
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/15 11:54
     */
    public void replaceSpace1(String resource) {
        StringBuilder sb = new StringBuilder();
        char[] chars = resource.toCharArray();
        for (char char1 : chars) {
            if (" ".equals(String.valueOf(char1))) {
                sb.append("%20");
            }else {
                sb.append(char1);
            }
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testReplaceSpace() {
        replaceSpace(resource);
    }

    @Test
    public void testReplaceSpace1() {
        replaceSpace1(resource);
    }
}
