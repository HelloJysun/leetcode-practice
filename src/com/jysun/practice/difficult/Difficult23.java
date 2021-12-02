package com.jysun.practice.difficult;

import com.jysun.practice.datastruct.ListNode;
import com.jysun.practice.simple.Simple21;

/**
 * 合并K个升序链表
 *
 * @author jysun
 * @since 2021/12/2
 */
public class Difficult23 {

    public static void main(String[] args) {
        Difficult23 obj = new Difficult23();
        ListNode node1_1 = new ListNode(1);
        ListNode node1_4 = new ListNode(4);
        ListNode node1_5 = new ListNode(5);
        node1_1.next = node1_4;
        node1_4.next = node1_5;
        ListNode node2_2 = new ListNode(1);
        ListNode node2_3 = new ListNode(3);
        ListNode node2_4 = new ListNode(4);
        node2_2.next = node2_3;
        node2_3.next = node2_4;
        ListNode node3_2 = new ListNode(2);
        ListNode node3_6 = new ListNode(6);
        node3_2.next = node3_6;
        ListNode[] lists = {node1_1, node2_2, node3_2};
        System.out.println(obj.mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = new Simple21().mergeTwoLists(res, list);
        }
        return res;
    }

    public ListNode mergeKListsRecursion(ListNode[] lists) {
        return mergeTwoLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeTwoLists(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = left + right >> 1;
        return new Simple21().mergeTwoLists(mergeTwoLists(lists, left, mid), mergeTwoLists(lists, mid + 1, right));
    }
}
