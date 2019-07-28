package com.ryang.bookdemo.stream;

import lombok.Data;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: renyang
 * @Date: 2019/2/26 17:16
 * @Description:
 */
public class StreamDemo {

    /**
     * Description: 1.创建Stream对象
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/23 16:41
     */
    public void creatStream() {
        // 1.Individual values
        Stream stream1 = Stream.of("a", "b", "c");

        // 2.利用数据创建Stream
        String[] args = new String[]{"a", "b", "c"};
        Stream stream2 = Stream.of(args);

        // 3.使用Collections接口创建
        List<String> list = Arrays.asList(args);
        Stream stream3 = list.stream();
        forEachStream(stream3);
    }

    /**
     * Description: 2.将流转换为其它数据结构
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/23 17:13
     */
    public void transformStream(){
        Stream<String> stream = Stream.of("a", "b", "c", "d");
        // 1.将Stream转为Array
        String[] array = stream.toArray(String[]::new);

        // 2.Stream转为Collection
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set<String> set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));

        // 3.stream转为String
        String str = stream.collect(Collectors.joining());
        System.out.println(str);
    }



    private void forEachStream(Stream stream){
        stream.forEach(System.out::println);
    }

    @Data
    class User {
        private Integer age;
        private String name;
        private String sex;
    }
}
