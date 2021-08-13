package com.jysun.practice.offer;

import com.jysun.practice.datastruct.ListNode;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author jysun
 * @since 2021/8/11
 */
public class Offer24 {

    public static void main(String[] args) {
        Offer24 obj = new Offer24();
        ListNode head1 = ListNode.random(5);
        System.out.println(head1);
        System.out.println(obj.reverseList(head1));

        ListNode head2 = ListNode.random(0);
        System.out.println(head2);
        System.out.println(obj.reverseList(head2));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
}