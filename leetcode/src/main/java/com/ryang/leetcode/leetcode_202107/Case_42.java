package com.ryang.leetcode.leetcode_202107;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划 单调栈
// 👍 2479 👎 0

/**
 * 解法1：动态规划
 * 思路：每个柱子能接水的高度=min(该柱子左边最高柱子,右边最高柱子中较小的高度)-该柱子高度
 *
 * */
public class Case_42 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Case_42().trap(height));
    }

    public int trap(int[] height) {
        int ans = 0;
        if (height.length < 3) {
            return ans;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax [0] = height[0];
        rightMax [height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length - 1; i++) {
            // 正向遍历数组，找到每个元素左边最大高度
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for (int i = height.length - 2; i > 0; i--) {
            // 反向遍历数组，找到每个元素右边最大高度
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }


        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
