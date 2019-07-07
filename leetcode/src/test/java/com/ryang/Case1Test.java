package com.ryang;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/11/27 18:16
 * @Description:
 */
public class Case1Test {

    private final int[] nums = new int[]{2, 7, 11, 15};
    private final int target = 9;
    private Case1 case1 = new Case1();

    @Test
    public void twoSum() throws Exception {
        int[] result = case1.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    @Test
    public void twoSum1() throws Exception {
        int[] result = case1.twoSum1(nums, target);
        System.out.println(result[0] + " " + result[1]);

    }

    @Test
    public void twoSum2() throws Exception {
        int[] result = case1.twoSum2(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}