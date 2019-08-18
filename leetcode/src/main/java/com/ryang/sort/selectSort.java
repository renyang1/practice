package com.ryang.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: renyang
 * @Date: 2019/8/14 14:42
 * @Description: 选择排序:类似冒泡排序，但每趟只会交换两个元素的位置，而冒泡排序每次都会交换相邻位置元素
 */
public class selectSort {

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;// 第i个最小值数组下标
            for (int j = i +1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;// 仅仅先记录下标，不交换值
                }
            }
            if (minIndex != i) {// 与数组中第i个最小值交换位置
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[] array = {5,7,4,3,8,6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
