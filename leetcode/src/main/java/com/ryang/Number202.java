package com.ryang;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: renyang
 * @Date: 2019/3/5 17:19
 * @Description: 编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例:

输入: 19
输出: true
解释:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class Number202 {

    public static void main(String[] args) {
        isHappy(25);
    }

    /**
     * Description: 判断一个数是否是'快乐数'
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/3/5 17:53
     */
    // todo:
    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        boolean isHappy = false;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0; // 平方和

        while (n != 0 ) {// 平方和计算
            int a = n % 10;
            sum += a*a;
            n = n / 10;

        }

        return isHappy;
    }
}
