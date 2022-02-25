package com.jysun.practice.medium;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author json
 * @since 2022/2/25
 */
public class Medium82 {

    public static void main(String[] args) {
        ListNode head = ListNode.array2Linked(new int[]{1, 1, 1, 2, 3});
        System.out.println(new Medium82().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
