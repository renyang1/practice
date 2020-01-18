package com.ryang.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author renyang
 * @date: 2019/10/22 16:42
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<String> targetList = new ArrayList<>();
        for (int i = 0; i < size; i++){
            String s = sc.next();
            targetList.add(s);
        }
        for (int i = 0; i < targetList.size(); i++) {
            targetList.set(i, Main.sort(targetList.get(i)));
        }

        List<String> rs = new ArrayList<>();
        for (String target : targetList) {
            if (!rs.contains(target)) {
                rs.add(target);
            }
        }
        System.out.println(rs.size());
    }

    /**
     *
     * Description: 字符串排序
     *
     * @param:
     * @return:
     * @date: 2019/10/22 20:04
     */
    private static String sort(String src) {
        char[] chars = src.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                char temp;
                if (chars[i] > chars[j]) {
                    // 交换位置
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }


}
