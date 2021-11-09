package com.ryang.leetcode.leetcode_202108;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 实现思路：
 * */
public class Case_jzoff_62 {


    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int removeIndex = 0;
        while (list.size() > 1) {
            // 这里-1是因为从本身开始数，所以要排除自身
            removeIndex = (removeIndex + m -1) % list.size();
            list.remove(removeIndex);

        }
        return list.get(0);
    }

    public static void main(String[] args) {
//        System.out.println(new Case_jzoff_62().lastRemaining(9, 13));
        int i = 0;
        ++i;
        System.out.println(i);

        i++;
        System.out.println(i);

    }
}
