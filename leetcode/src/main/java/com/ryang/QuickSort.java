package com.ryang;

/**
 * @Auther: renyang
 * @Date: 2019/1/15 16:29
 * @Description: 快速排序
 */
public class QuickSort {

    public void sort(int[] arrays, int start, int end){

        if (start >= end) {// 递归基线条件
            return;
        }

        int middleIndex = this.getMiddleIndex(arrays, start, end);
        sort(arrays, start, middleIndex - 1);
        sort(arrays,middleIndex + 1, end);
    }


    // 将数组分成两部分
    private int getMiddleIndex(int[] arrays, int start, int end) {

        int middleValue = arrays[start];// 基准数

        while (start < end) {

            // 开始从右往左遍历目标数组
            while (start < end && arrays[end] >= middleValue) {
            // 当右侧的数大于等于基准数时，向左移动
            end--;
        }
        // 当右侧当前end对应数小于基准数时，将该数移到当前start对应的位置
        arrays[start] = arrays[end];

            // 开始从左往右遍历目标数组
            while (start < end && arrays[start] <= middleValue) {
                // 当左侧的数小于等于基准数时，向右移动
                start++;
            }
            // 当左侧当前start对应数大于基准数时，将该数移到当前end对应的位置
            arrays[end] = arrays[start];
        }
        // 当start = end时(相遇)，设置基准数位置
        arrays[start] = middleValue;
        return start;
    }

}
