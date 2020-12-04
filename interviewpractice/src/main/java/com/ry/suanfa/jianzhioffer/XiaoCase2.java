package com.ry.suanfa.jianzhioffer;

import java.util.*;

/**
 * Description:
 * 现在有一个数列N，分别为A1,A2,A3.......AN，现在取一个三元组(i,j,k) （1 <= i < j < k < N）
 *
 * 现在要求统计满足以下条件的三角形
 *
 * Ai,Aj,Ak各不相同，并且三角形的三边为Ai,Aj,Ak。
 *
 * 1≤N≤100
 *
 * 1≤Ai≤1e9
 *
 * 1≤Aj≤1e9
 *
 * 1≤Ak≤1e9
 *
 * Input Format
 *
 * 5
 *
 * 4 4 9 7 5
 *
 * Constraints
 *
 * 输入： 第一行一个数 N 第二行N个数：A1,A2,A3.....AN
 *
 * 输出： 选出满足条件的三角形的个数
 *
 * Output Format
 *
 * 5
 *
 * @author renyang
 * @date 2020-10-23
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class XiaoCase2 {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int[] arrays =new int[sc.nextInt()];
//
//        for (int i = 0 ; i < arrays.length; i++) {
//            arrays[i] = sc.nextInt();
//        }

        int[] arrays = new int[]{4, 4, 9, 7, 5};
        Arrays.sort(arrays);
        int count = 0;
        for (int i = arrays.length - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arrays[l] + arrays[r] > arrays[i]) {
                    if (arrays[i] != arrays[r] && arrays[r] != arrays[l]) {
                        count = count + (r - l);
                        for (int j = r-1; j > l ; j--) {
                            // 判断区间内和arrays[r]相等的数，避免出现4 5 6 7 7 8 这种case
                            if (arrays[j] == arrays[r]) {
                                count -= 1;
                            }
                        }
                    }
                    r--;
                } else {
                    l++;
                }
            }
        }
        System.out.println(count);
    }


}
