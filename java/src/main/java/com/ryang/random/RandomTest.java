package com.ryang.random;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-10-12
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            generateCandidateNumber().length();
        }

//        System.out.println(generateCandidateNumber());
//        System.out.println(generateCandidateNumber());
    }

    /**
     * 获取 0 到 number - 1 的随机数
     *
     * @param number
     * @return
     */
    public static int rand(final int number) {
        return ThreadLocalRandom.current().nextInt(number);
    }

    /**
     * @return 随机 from 到 to 范围的随机数
     */
    public static int rand(final int from, final int to) {
        if (to < from) {
            throw new IllegalArgumentException("to : " + to + " < " + "from : " + from);
        }
        return RandomTest.rand((to - from) + 1) + from;
    }

    /**
     * 生成学生考号
     *
     * @return
     */
    public static String generateCandidateNumber() {
        LocalDate localDate = LocalDate.now();
        int randomInt = ThreadLocalRandom.current().nextInt(999999);
        if (String.valueOf(randomInt).length() < 6) {
            System.out.println(randomInt);
            System.out.println(localDate.toString().replaceAll("-", "").substring(2) + String.format("%0" + 6 + "d", randomInt));
        }
        return localDate.toString().replaceAll("-","").substring(2) + String.format("%0" + 6 + "d", randomInt);
    }
}
