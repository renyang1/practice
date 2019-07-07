package com.ryang.bookdemo.Chapter3;

import java.io.IOException;

/**
 * @Auther: renyang
 * @Date: 2019/2/21 18:51
 * @Description: 测试在lambda表达式中处理异常
 */
public class TestException {

    public static void main(String[] args) {
        MyInterface myInterface = (String s) -> s.length();
        int length = get("RY", (String s) -> {
//            try {
                if (s.equals("RY")){
                    throw new IOException("Boss");
                }
                return s.length();
//            }catch (Exception e){
//                throw new RuntimeException("...");
//            }
        });
        System.out.println(length);
    }

    public static int get(String targetString, MyInterface myInterface) {

        try {
            return myInterface.process(targetString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
