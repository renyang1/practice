package com.ryang.stream;

import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.compile;
import static org.junit.Assert.*;

/**
 * @Auther: renyang
 * @Date: 2019/7/23 17:08
 * @Description:
 */
public class StreamDemoTest {

    @Test
    public void creatStream() {
        new StreamDemo().creatStream();
    }

    @Test
    public void transformStream() {

    }

    @Test
    public void streamOperation() {
        new StreamDemo().streamIntermediateOperation();
    }


    @Test
    public void streamTerminalOperation() {
        new StreamDemo().streamTerminalOperation();
    }

    @Test
    public void streamReduceTerminalOperation() {
        new StreamDemo().streamReduceTerminalOperation();
    }

    @Test
    public void streamCollectors() {
        new StreamDemo().streamCollectors();
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add(null);
        list.add("b");

//        list = list.stream().map(s -> (s == null) ? "1" : s).collect(Collectors.toList());
        list = list.stream().map(s -> {
            if (s == null) s = "1";
            return s;
        }).collect(Collectors.toList());
        System.out.println(list);
    }


    @Test
    public void test1() {
        String price = "10.011";
        BigDecimal bigDecimal = new BigDecimal(price);
        int value = bigDecimal.multiply(new BigDecimal(100)).intValue();
        System.out.println(value);
    }

    @Test
    public void isInteger() {
        List<List<String>> lists = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        List<String> list1 = new ArrayList<>();
        list1.add("c");
        list1.add("d");

        lists.add(list);
        lists.add(list1);

//        List<String> list2 = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        List<String> list2 = lists.stream().flatMap(list3 -> list3.stream()).collect(Collectors.toList());
        System.out.println(list2.toString());

    }


    @Test
    public void isDouble() {

        User user1 = new User();
        user1.setName("a");
        user1.setAge(1);
        user1.setMoney(3);

        User user2 = new User();
        user2.setName("a");
        user2.setAge(2);
        user2.setMoney(2);

        User user3 = new User();
        user3.setName("b");
        user3.setAge(3);
        user3.setMoney(3);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user1);

        Map<String, Optional<User>> userMap = users.stream().collect(
                Collectors.groupingBy(User::getName,
                        Collectors.maxBy(Comparator.comparingInt(User::getMoney))));
        System.out.println(userMap.toString());

        // todo:如何只返回name相同的一个user对象
        Set<String> nameSet = new HashSet<>();
        List<User> users1 = users.stream().filter(user -> {
            boolean flag = !nameSet.contains(user.getName());
            if (flag) {
                nameSet.add(user.getName());
                return true;
            }else {
                return false;
            }
        }).collect(Collectors.toList());

        System.out.println(users1.toString());
    }

    @Data
    public static class User {

        /** 姓名 */
        private String name;

        /** 年龄 */
        private Integer age;

        /** 压岁钱 */
        private Integer money;

    }
}