package com.ry.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @Auther: renyang
 * @Date: 2019/4/18 15:01
 * @Description:
 */
public class LinkedListTest {

    LinkedList<String> linkedList = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    Set<String> set = new HashSet<>();

    TreeSet<String> treeSet = new TreeSet();

    @Before
    public void init() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("a");

        stack.push("a");
        stack.push("b");
        stack.push("c");

        set.add("a");
        set.add("b");
        set.add("c");

        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");


    }

    @Test
    public void getTest() {
        System.out.println(linkedList.get(2));
    }

    @Test
    public void stackGet() {
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.search("b"));
    }

    @Test
    public void setTest() {
        String s = "任";
        byte[] bytes = s.getBytes();
        System.out.println(bytes[0]);
        char[] chars = s.toCharArray();
        System.out.println(chars[0]);
    }

    @Test
    public void sublist() {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> list1 = list.subList(1, 2);
        list1.add("4");
        list.add("5");
        for (String l : list1) {
            System.out.println(l);
        }
        System.out.println(list.toString());
    }

    @Test
    public void arrayList() {
        String[] args = new String[]{"1", "2", "3"};
        List<String> list = Arrays.asList(args);
        args[0] = "4";
        System.out.println(list.toString());
    }

    @Test
    public void test1() {

    }
}
