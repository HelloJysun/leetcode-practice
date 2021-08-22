package com.jysun.practice.datastruct;

import java.util.Random;

/**
 * @author Jysun
 * @description ListNode
 * @date 2020/4/15 21:45
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode random(int count) {
        Random random = new Random();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < count; i++) {
            cur.next = new ListNode(random.nextInt(10));
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode orderList(int count) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        for (int i = 1; i <= count; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
