package com.ry.suanfa.jianzhioffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: renyang
 * @Date: 2019/8/8 20:24
 * @Description: 四十：数组中只出现一次的数字。
 *                    一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *                    要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Case40 {

    private int[] array = {3, 4, 5, 6, 4, 3, 7, 5, 6, 8};
    private int[] num1;
    private int[] num2;

    /**
     * Description: 将数字做为key,出现的次数做为value.若value的值为1，则说明只出现了一次
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/8 20:48
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            }else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if (m.getValue() == 1) {
                    System.out.println(m.getKey());
                }
        }

    }

    @Test
    public void test() {
        Case40 case40 = new Case40();
        case40.FindNumsAppearOnce(array, num1, num2);
    }


}
