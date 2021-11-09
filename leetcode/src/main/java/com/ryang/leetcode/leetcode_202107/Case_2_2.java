package com.ryang.leetcode.leetcode_202107;

/**
 * Description:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class Case_2_2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        // 预先指针
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;

        while (node1 != null || node2 != null) {
            int val1 = node1 == null ? 0 : node1.val;
            int val2 = node2 == null ? 0 : node2.val;

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;

            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
        }

        // 当node1、node2均遍历完毕，但需要进位
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }

        return pre.next;
    }


    public static void main(String[] args) {

        Case_2_2.ListNode node1_1 = new Case_2_2().new ListNode(2);
        Case_2_2.ListNode node1_2 = new Case_2_2().new ListNode(4);
        Case_2_2.ListNode node1_3 = new Case_2_2().new ListNode(3);
        node1_1.next = node1_2;
        node1_2.next = node1_3;

        Case_2_2.ListNode node2_1 = new Case_2_2().new ListNode(5);
        Case_2_2.ListNode node2_2 = new Case_2_2().new ListNode(6);
        Case_2_2.ListNode node2_3 = new Case_2_2().new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;

        ListNode node = new Case_2_2().addTwoNumbers(node1_1, node2_1);
        System.out.println(node.val);
    }
}
