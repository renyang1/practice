package com.ry.suanfa.jianzhioffer;

import java.util.Scanner;

/**
 * Description: https://www.hackerrank.com/contests/2020-1024-x-coder/challenges
 *
 * @author renyang
 * @date 2020-10-23
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class XiaoCase1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arrays = new int[Integer.valueOf(sc.nextLine())];

        String[] s = new String[]{};
        if (sc.hasNextLine()) {
            s = sc.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                arrays[i] = Integer.valueOf(s[i]);
            }
        }

        System.out.println(subArraySum(arrays, 0));
//        int[] arrays = new int[]{1, 3, -4, 2, 2, -2};


    }

    public static int subArraySum(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和
        long[] sum = new long[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int result = 0;
        // 穷举所有子数组
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 0) {
                result++;
            }
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k)
                    result++;
            }

        }
        return result;
    }

}
