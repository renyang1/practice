package com.ryang.leetcode_202107;

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
public class Case_2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode node;

        int node1Value = node1.val;
        int node2Value = node2.val;
        int a = 0;

        int nodeValue = node1Value + node2Value;

        if (nodeValue >= 10) {
            nodeValue = nodeValue - 10;
            a = 1;
        }

        node = new ListNode(nodeValue);

        ListNode currNode1 = node1.next;
        ListNode currNode2 = node2.next;
        ListNode currentNextNode = node;

        while (currNode1 != null || currNode2 != null || a == 1) {
            node1Value = currNode1 == null ? 0 : currNode1.val;
            node2Value = currNode2 == null ? 0 : currNode2.val;

            nodeValue = node1Value + node2Value + a;
            a = 0;
            if (nodeValue >= 10) {
                nodeValue = nodeValue - 10;
                a = 1;
            }
            ListNode next = new ListNode(nodeValue);
            currentNextNode.next = next;
            currentNextNode = next;

            currNode1 = currNode1 == null ? null : currNode1.next;
            currNode2 = currNode2 == null ? null : currNode2.next;
        }
        return node;
    }


    public static void main(String[] args) {

        Case_2.ListNode node1_1 = new Case_2().new ListNode(2);
        Case_2.ListNode node1_2 = new Case_2().new ListNode(4);
        Case_2.ListNode node1_3 = new Case_2().new ListNode(3);
        node1_1.next = node1_2;
        node1_2.next = node1_3;

        Case_2.ListNode node2_1 = new Case_2().new ListNode(5);
        Case_2.ListNode node2_2 = new Case_2().new ListNode(6);
        Case_2.ListNode node2_3 = new Case_2().new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;

        ListNode node = new Case_2().addTwoNumbers(node1_1, node2_1);
        System.out.println(node.val);
    }
}
