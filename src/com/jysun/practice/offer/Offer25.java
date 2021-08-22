package com.jysun.practice.offer;

import com.jysun.practice.datastruct.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * @author json
 * @since 2021/8/21
 */
public class Offer25 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.orderList(3);
        ListNode l2 = ListNode.orderList(4);

        Offer25 obj = new Offer25();
        System.out.println("l1 : " + l1);
        System.out.println("l2 : " + l2);
        System.out.println(obj.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else cur.next = l2;
        return dummy.next;
    }
}
