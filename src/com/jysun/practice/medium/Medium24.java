package com.jysun.practice.medium;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author Jysun
 * @description 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @date 2020/8/20 17:44
 */
public class Medium24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Medium24 obj = new Medium24();
        System.out.println(obj.swapPairs(node1));
    }

    /**
     * 递归三要素
     * 终止条件：没有结点或一个结点即node == null || node.next == null
     * 返回值：返回反转后的头结点
     * 做什么：将当前结点与next结点反转，返回next
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = swapPairs(head.next.next);
        ListNode node = head.next;
        node.next = head;
        head.next = nextHead;
        return node;
    }
}
