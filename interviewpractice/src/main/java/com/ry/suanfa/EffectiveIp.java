package com.ry.suanfa;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/9/10 16:04
 * @Description: 给定一个字符串只含有数字，判定这个字符串能表达的所有IP地址
 */
public class EffectiveIp {

    private final String resource = "124211233";

    public void findEffctiveIp(String resource) {
        int len = resource.length();
        if (len < 4 || len > 12) {
            // 检验传入字符串是否有效
            System.out.println("字符串为空或长度不合法！");
            return;
        }

        // 每个for循环中需要保证当前ip的位数大于1小于4且剩余的位数能保证后面的ip至少有1位数
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    if (len - k >= 4) {
                        continue;
                    }
                    int a = Integer.parseInt(resource.substring(0, i));
                    int b = Integer.parseInt(resource.substring(i, j));
                    int c = Integer.parseInt(resource.substring(j, k));
                    int d = Integer.parseInt(resource.substring(k));

                    // 判读ip是否合法
                    if (a > 255 || b > 255 || c > 255 || d > 255) {
                        continue;
                    }
                    String ip = a + "." + b + "." + c + "." + d;
                    System.out.println(ip);
                }
            }
        }
    }

    @Test
    public void test() {
        new EffectiveIp().findEffctiveIp(resource);
    }
}
