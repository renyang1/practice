package com.ryang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: renyang
 * @Date: 2018/11/8 11:30
 * @Description: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
                 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
                 示例:
                 给定 nums = [2, 7, 11, 15], target = 9
                 因为 nums[0] + nums[1] = 2 + 7 = 9
                 所以返回 [0, 1] */
public class Case1 {
    /**
     * Description:ryang解法
     * @auther: renyang
     * @param: 
     * @return:
     * @date: 2018/11/27 19:21
     */
    public int[] twoSum(int[] nums, int target) {
        int[] resultNum = new int[2];
        for (int i = 0; i < nums.length; i++){
            int anotherNum = target - nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] == anotherNum){
                    resultNum[0] = i;
                    resultNum[1] = j;
                    break;
                }
            }
        }
        return resultNum;
    }

    /**
     * Description: 将时间复杂度从上面的O(n2)降为 O(n)
     *              但空间复杂度从O(1)变为O(n)
     * @auther: other
     * @param:
     * @return:
     * @date: 2018/11/27 19:22
     */
    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        // 为数组中的每个数建立索引
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No correspond number!");
    }

    /**
     * Description: 将两遍循环数组优化为1次
     * @auther: other
     * @param:
     * @return:
     * @date: 2018/11/27 19:35
     */
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No correspond number!");
    }


}
