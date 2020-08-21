package com.jysun.practice.simple;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author Jysun
 * @description 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @date 2020/8/21 11:23
 */
public class Simple83 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node1_1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node3_3 = new ListNode(3);
        node1.next = node1_1;
        node1_1.next = node2;
        node2.next = node3;
        node3.next = node3_3;

        Simple83 obj = new Simple83();
        System.out.println(obj.deleteDuplicates2(node1));
//        System.out.println(obj.deleteDuplicates(node1));
    }

    /**
     * 递归三要素
     * 终止条件：head == null || head.next == null
     * 返回值：返回删除后的链表
     * 作甚：将当前结点与下一删除后的头结点比较并删除
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
