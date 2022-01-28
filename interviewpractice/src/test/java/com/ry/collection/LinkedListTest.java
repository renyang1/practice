package com.ry.collection;

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

    @Test
    public void getTest() {
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add(1, null);
        System.out.println(linkedList.get(1));
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("i:" + i + ", size:" + list.size());
            if (i == 3) {
                list.remove(i);
            }
            // 若移除的是最后一个元素，则会抛出IndexOutOfBoundsException；移除非最后一个元素则能正常遍历
            // 最后一个元素被移除后，get(i)中i这个位置已经没有元素了
            System.out.println(i + ":"+ list.get(i));
        }
    }
}
