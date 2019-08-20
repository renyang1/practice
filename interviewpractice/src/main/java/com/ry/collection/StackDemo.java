package com.ry.collection;

import org.junit.Test;

import java.util.Stack;

/**
 * @Auther: renyang
 * @Date: 2019/8/20 16:28
 * @Description: Stack继承Vector，是一种只能在一端进行插入或删除操作的线程表。(先进后出)
 */
public class StackDemo {

    @Test
    public void test() {

        // 1.实例化
        Stack<String> stack = new Stack();

        // 2.进栈 push()
        stack.push("a");
        stack.push("b");
        stack.push("c");

        // 3.取栈顶值 peek()
        String s = stack.peek();
        System.out.println(s);

        // 4.出栈pop()
        String pop = stack.pop();
        System.out.println(pop);
    }
}
