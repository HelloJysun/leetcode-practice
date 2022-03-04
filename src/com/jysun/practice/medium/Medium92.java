package com.jysun.practice.medium;

import com.jysun.practice.datastruct.ListNode;

/**
 * 反转链表II
 *
 * @author jysun
 * @since 2022/3/3
 */
public class Medium92 {

    public static void main(String[] args) {
        ListNode head = ListNode.orderList(5);
        System.out.println(new Medium92().reverse(head));
        ListNode head2 = ListNode.orderList(5);
        System.out.println(new Medium92().reverseFor(head2));
        ListNode head3 = ListNode.orderList(5);
//        [4,-2,-4,0,-2,-2,-1,-2]
        System.out.println(new Medium92().reverseBetween(head3, 2, 4));
    }

    /**
     * 反转链表的left到right的节点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        right -= left;
        while (left-- > 1) {
            leftPrev = leftPrev.next;
        }
        // 反转
        reverse(leftPrev, right);
        return dummy.next;
    }

    public ListNode reverse(ListNode prev, int length) {
        ListNode cur = prev.next;
        while (cur != null && length-- > 0) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return prev;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode reverse = reverse(next);
        head.next = null;
        next.next = head;
        return reverse;
    }

    public ListNode reverseFor(ListNode head) {
        if (head == null) return null;
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
