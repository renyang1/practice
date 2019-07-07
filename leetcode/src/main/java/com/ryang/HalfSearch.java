package com.ryang;

/**
 * @Auther: renyang
 * @Date: 2019/1/15 17:39
 * @Description: 二分查找
 */
public class HalfSearch {

    /**
     * Description:普通实现
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/15 17:45
     */
    public int search(int[] arrays, int aimNumber) {
        int start = 0;
        int end = arrays.length - 1;

        while (start <= end) {

            int middleIndex = (start + end) / 2;
            int middleValue = arrays[middleIndex];

            if (middleValue == aimNumber) {
                return middleIndex;
            }
            if (middleValue > aimNumber) {
                // 中间数大于目标值，调整end对应的右边下标的值
                end = middleIndex - 1;
            }
            if (middleValue < aimNumber) {
                start = middleIndex + 1;
            }
        }
        return -1;
    }


    /**
     * Description:递归二分查找
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/15 17:58
     */
    public int recursiveSearch(int[] arrays, int start, int end, int aimNumber) {

        if (start > end) {
            return -1;
        }

        int middleIndex = (end + start) / 2;
        int middleValue = arrays[middleIndex];
        if (aimNumber == middleValue) {
            // 目标值等于中间值，返回中间数下标
            return middleIndex;
        }
        if (aimNumber > middleValue) {
            // 目标值大于中间值
            return recursiveSearch(arrays, middleIndex + 1, end, aimNumber);
        }

        if (aimNumber < middleValue) {
            // 目标值小于中间值
            return recursiveSearch(arrays, start, middleIndex - 1, aimNumber);
        }
        return -1;
    }
}
