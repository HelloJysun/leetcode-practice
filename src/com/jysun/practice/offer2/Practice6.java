package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.ListNode;

/**
 * 从尾到头打印链表
 *
 * @author jysun
 * @since 2022/2/16
 */
public class Practice6 {

    public int[] solution(ListNode head) {
        // 两次遍历法，第一次统计链表长度用于构造结果数组
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int[] res = new int[size];
        while (head != null) {
            res[--size] = head.val;
            head = head.next;
        }
        return res;
    }
}
