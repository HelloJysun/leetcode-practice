package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.ListNode;

/**
 * 反转链表
 *
 * @author jysun
 * @since 2022/2/24
 */
public class Practice24 {

    public static void main(String[] args) {
        ListNode head = ListNode.orderList(5);
        System.out.println(head);
        System.out.println(new Practice24().reverseList(head));
    }

    /**
     * 迭代法，不断把节点拔掉插在头节点前，最终返回
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }
}
