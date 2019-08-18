package com.ry.suanfa.jianzhioffer;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/8/16 14:36
 * @Description: 输入一个链表，反转链表后，输出链表的所有元素
 */
public class Case4 {

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public Node reverse(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {// 交换位置
            // todo：待理解
            // 保存要反转到头的那个节点
            next = head.next;
            // 要反转的那个节点指向已经反转的上一个节点(备注:第一次反转的时候会指向null)
            head.next = pre;
            // 上一个已经反转到头部的节点
            pre = head;
            // 一直向链表尾走
            head = next;
        }
        return pre;
    }

    @Test
    public void test() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        new Case4().reverse(a);
        while (e != null) {
            System.out.println(e.data);
            e = e.next;
        }
    }
}
