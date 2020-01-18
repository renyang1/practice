package com.ryang.niuke;

import java.util.Scanner;

/**
 * @author renyang
 * @date: 2019/10/22 20:32
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = 1; i < size; i++) {
            int index = i;
            // 记录错误数字
            int change = 0;
            while (change != 2) {
                int before = nums[index-1];
                int after = nums[index];
                if (before > after) {
                    change++;
                    index++;
                }
            }


            if (change == 2) {

            }

        }
    }


}
