package com.ryang.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: renyang
 * @Date: 2019/8/14 11:12
 * @Description: 冒泡排序:双层循环，最外层每次循环都找到数据第i个最小(大)的数，放到数组的第i个位置上
 *                       假设有一个无序序列 {4，3，1，2, 5}
 *                       第一趟排序：通过两两比较，找到第一小的数值 1 ，将其放在序列的第一位。
 *                       第二趟排序：通过两两比较，找到第二小的数值 2 ，将其放在序列的第二位。
 *                       第三趟排序：通过两两比较，找到第三小的数值 3 ，将其放在序列的第三位。
 */
public class BubbleSort {

    public void sort(int[] array) {
        for (int i = 0; i< array.length; i++) {// 每一趟循环都将找出第i个最小的数，放到数组第i个位置上
            int temp;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test() {
        int[] array = {3, 2, 5, 7, 8 ,1};
        sort(array);
    }
}
