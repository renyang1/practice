package com.ryang.leetcode.leetcode_202107;

/**
 * Description：
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 * @author renyang
 * @date 2021-07-23
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Case88_2 {

    /**
     * 逆向双指针解法，不需要借助中间数组变量存储数据，空间复杂度低
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1;
        int cur;
        int tail = m + n -1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                cur = nums2[p2];
                p2--;
            }else if (p2 < 0) {
                cur = nums1[p1];
                p1--;
            }else if (nums1[p1] < nums2[p2]) {
                cur = nums2[p2];
                p2--;
            }else {
                cur = nums1[p1];
                p1--;
            }
            nums1[tail] = cur;
            tail--;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{1, 5, 6};
        new Case88_2().merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
