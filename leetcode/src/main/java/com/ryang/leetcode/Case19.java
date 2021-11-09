package com.ryang.leetcode;

import org.junit.Test;

/**
 * @author renyang
 * @date: 2019/10/10 09:29
 * des:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Case19 {

    /**
     *
     * Description:使用一个循环实现，利用双指针。需要注意两个指针间的步长及结束条件
     *
     * @param:
     * @return:
     * @date: 2019/10/10 12:56
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 声明虚假节点，避免只有一个节点等特殊情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 控制两个指针间的距离
        for (int i = 0; i < n; i ++) {
            first = first.next;
        }

        // 控制遍历的结束点
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    @Test
    public void test (){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        this.removeNthFromEnd(listNode, 2);
    }

}

class ListNode{
    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}