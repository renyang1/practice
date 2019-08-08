package com.ry.suanfa.jianzhioffer;

import java.util.Arrays;

/**
 * @Auther: renyang
 * @Date: 2019/8/8 19:16
 * @Description: 剑指offer51: 数组中的重复数字
 *               在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 *               也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 *               那么对应的输出是第一个重复的数字2。
 */
public class Case50 {

    private int[] numbers = {5,3,1,0,2,5,3};
    private int[] duplication = new int[1];

    /**
     * Description: 先将数组排序，若相邻两个数相等则说明数字重复
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/8 19:43
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * Description: hash法:
     *              将数组中的数字映射到新数组索引值为该数字的位置上，值为次数，若映射时值不为0，说明之前已经有值映射到该位置处，即该数字重复。
     *              如hash[] = {0,0,0,0,0,0},加入第一个数字为3，则hash[] = {0,0,0,1,0,0}
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/8 19:45
     */
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        int[] hash = new int[length];
        for (int i = 0; i < length; i++) {
            if (hash[numbers[i]] == 0) {// 数字还未重复
                hash[numbers[i]]++;// 将数组索引值为该数字的数组值+1，表示该数字出现了一次
            }else {// 之前已有该数字出现
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Case50 case50 = new Case50();
//        boolean res = case50.duplicate1(case50.numbers, case50.numbers.length, case50.duplication);
        boolean res = case50.duplicate2(case50.numbers, case50.numbers.length, case50.duplication);
        if (res) {
            System.out.println(case50.duplication[0]);
        }
    }
}
