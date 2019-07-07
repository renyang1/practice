package com.ryang.bookdemo.Chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: renyang
 * @Date: 2019/2/26 17:16
 * @Description:
 */
public class StreamAPI {

    public static void main(String[] args) {
        StreamAPI streamAPI = new StreamAPI();
        List<String> numbers = new ArrayList<>();
        numbers.add("start");
        streamAPI.method1(numbers);
        numbers.add("end");
        System.out.println(numbers.toString());
    }

    public void method1(List<String> numbers) {
        numbers.add("method1");
        for (int i = 0; i < 3; i++) {
            numbers.add(String.valueOf(i));
        }
    }
}
