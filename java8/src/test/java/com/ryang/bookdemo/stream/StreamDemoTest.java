package com.ryang.bookdemo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        list = list.stream().map(s -> {if(s == null) s = "1"; return s;}).collect(Collectors.toList());
        System.out.println(list);
    }
}