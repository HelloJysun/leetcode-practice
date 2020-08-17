package com.jysun.practice.simple;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author Jysun
 * @description 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @date 2020/8/17 17:16
 */
public class Simple21 {

    public static void main(String[] args) {
        Simple21 obj = new Simple21();
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_4 = new ListNode(4);
        l1.next = l1_2;
        l1_2.next = l1_4;
        ListNode l2 = new ListNode(1);
        ListNode l2_3 = new ListNode(3);
        ListNode l2_4 = new ListNode(4);
        l2.next = l2_3;
        l2_3.next = l2_4;
//        System.out.println(obj.mergeTwoLists(l1, l2));
        System.out.println(obj.mergeTwoListsOpt(l1, l2));
    }

    /**
     * 遍历法
     * 思路：通过双指针遍历两个链表，依次比较将较小值插入到新链表中
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode cur = prev;
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
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return prev.next;
    }

    /**
     * 递归法
     * 思路：合并两个有序链表可以分解为两个链表较小结点后续的链表同另一个链表合并的子问题
     * 合并后的链表放在较小结点后即可
     * 终止条件：两个链表为空
     * 关键点在于如果其中一个链表为空后，应该返回的是另一个链表，因为返回值是合并后的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsOpt(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsOpt(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsOpt(l1, l2.next);
            return l2;
        }
    }
}
