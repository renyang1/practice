package com.ryang.sort;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-09-27
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Case5523 {

    private static final String YD = "./";
    private static final String HT = "../";


    public static void main(String[] args) {
        String[] logs = new String[]{"./","../","./"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        int qj = 0;
        for (String log : logs) {
            if (HT.equals(log)) {
                if (qj > 0) {
                    qj = qj - 1;
                }else {
                    continue;
                }
             } else if (YD.equals(log)) {
                continue;
            }else {
                // 前进
                qj += 1;
            }
        }
        return qj;
    }
}
