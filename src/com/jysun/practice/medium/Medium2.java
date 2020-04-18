package com.jysun.practice.medium;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author Jysun 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @description Medium2
 * @date 2020/4/15 21:45
 */
public class Medium2 {

    public static void main(String[] args) {
        ListNode node12 = new ListNode(1);
//        ListNode node14 = new ListNode(8);
//        ListNode node13 = new ListNode(9);
        ListNode node25 = new ListNode(9);
        ListNode node26 = new ListNode(9);
//        ListNode node24 = new ListNode(6);
//        node12.next = node14;
//        node14.next = node13;
        node25.next = node26;
//        node26.next = node24;
        Medium2 obj = new Medium2();
        ListNode res = obj.addTwoNumbers(node12, node25);
        System.out.println(res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode node = prev;
        boolean flag = false; // 进位标志
        while (l1 != null || l2 != null) {
            int d1 = l1 != null ? l1.val : 0;
            int d2 = l2 != null ? l2.val : 0;
            int cnt = flag ? d1 + d2 + 1 : d1 + d2;
            flag = false; // 重置
            if (cnt > 9) {
                flag = true;
                cnt = cnt % 10;
            }
            node.next = new ListNode(cnt);
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (flag) {
            node.next = new ListNode(1);
        }
        return prev.next;
    }
}
