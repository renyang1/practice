package com.ryang.leetcode.leetcode_202107;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 实现思路：使用双指针，前指针先走k步，即前后指针相差k,然后两个指针一起移动，等前指针走到尾部，则后指针即为所求结果
 * */
public class Case_jzoff_22_2 {

     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode front = head;
        ListNode latter = head;

        while (k-->0) {
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            latter = latter.next;
        }
        return latter;
    }

    public static void main(String[] args) {
        ListNode node0 = new Case_jzoff_22_2().new ListNode(1);
        ListNode node1 = new Case_jzoff_22_2().new ListNode(2);
        node0.next = node1;

        ListNode node2 = new Case_jzoff_22_2().new ListNode(3);
        node1.next = node2;

        ListNode node3 = new Case_jzoff_22_2().new ListNode(4);
        node2.next = node3;

        ListNode node4 = new Case_jzoff_22_2().new ListNode(5);
        node3.next = node4;

        ListNode kthFromEnd = new Case_jzoff_22_2().getKthFromEnd(node0, 1);
        System.out.println(kthFromEnd.val);
    }

}
