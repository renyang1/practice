package com.ryang.leetcode_202107;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 *
 * @author renyang
 * @date 2021-07-25
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Case_jzoff_61 {
    public boolean isStraight(int[] nums) {
        Set set = new HashSet();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                // 存在重复数字，则不满足条件
                return false;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }

        // 若最大值、最小值相差<5则能构成顺子
        if (max - min < 5) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,7,5,9,2};
        System.out.println(new Case_jzoff_61().isStraight(nums));
    }

}
