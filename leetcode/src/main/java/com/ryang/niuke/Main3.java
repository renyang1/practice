package com.ryang.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author renyang
 * @date: 2019/10/23 16:36
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        int rowClo = (int) Math.sqrt(list.size());
        int[][] src = new int[rowClo][rowClo];
        int size = 0;
        while (size < list.size()){
            for (int i = 0; i < rowClo; i++) {
                for (int j = 0; j < rowClo; j++) {
                    src[i][j] = list.get(size++);
                }
            }
        }

        // 转换数字
        int time = rowClo/2;
        int mod = rowClo % 2;
        if (mod != 0) {
            time += 1;
        }
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < rowClo; i++) {
            for (int j = 0; j < rowClo; j++) {
                if (list1.contains("" + j + i)) {
                    continue;
                }
                list1.add("" + i + j);
                int temp;
                temp = src[i][j];
                src[i][j] = src[j][i];
                src[j][i] = temp;
            }
        }

        for (int i = 0; i < rowClo; i++) {
            for (int j = 0; j < rowClo; j++) {
                System.out.print(src[i][j] + " ");
            }
            System.out.println();
        }
    }
}
