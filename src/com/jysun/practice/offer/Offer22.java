package com.jysun.practice.offer;

import com.jysun.practice.datastruct.ListNode;

/**
 * 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * @author jysun
 * @since 2021/8/20
 */
public class Offer22 {

    public static void main(String[] args) {
        Offer22 obj = new Offer22();
        ListNode head = ListNode.random(5);
        System.out.println(head);
        System.out.println(obj.getKthFromEnd(head, 2));
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode lo = head;
        ListNode hi = lo;
        while (--k > 0) {
            hi = hi.next;
        }
        while (hi != null && hi.next != null) {
            lo = lo.next;
            hi = hi.next;
        }
        return lo;
    }
}
