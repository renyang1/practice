package com.ry;

/**
 * @Auther: renyang
 * @Date: 2019/1/29 15:52
 * @Description:
 */
public class ReferenceTest {

    public static void main(String[] args) {

        int i = 1;
        new Thread(() -> {
            int j = i;
            j = j + 1;
            System.out.println(j);
            j++;
        }).start();
    }


}
