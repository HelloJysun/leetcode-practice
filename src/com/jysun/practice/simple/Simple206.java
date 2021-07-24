package com.jysun.practice.simple;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author Jysun
 * @description Simple206 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @date 2020/5/16 8:03
 */
public class Simple206 {

    public static void main(String[] args) {
        Simple206 obj = new Simple206();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(obj.reverseList(node1));
        System.out.println(obj.reverseListRecursion(node5));
    }

    /**
     * 迭代法
     * 使用一个额外下标cur记录当前翻转链表位置
     * 记录当前下标的下一节点，临时节点tmp，和数组交换类似
     * cur.next = tmp.next;
     * 由于不是单纯的交换相邻节点，而是相当于把下一节点插入到头节点处
     * tmp.next = head;
     * 改变新的头节点
     * head = tmp;
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 先考虑边界情况，节点0或1直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            // 将抽出来的下一节点指向当前头节点处，并升级该节点为头节点，确保cur不断后移
            next.next = head;
            head = next;
        }
        return head;
    }

    /**
     * 分治法
     * 翻转 1 2 3 4 5
     * 可以先递归翻转 2 3 4 5
     * 以此类推直到只剩下 5 时可以直接返回
     * 返回的 5 元素，需要将其上一层的 4 5 翻转并返回翻转后的头节点即 5
     * 此时 head = 4，递归调用返回 node = 5
     * 原本的 head.next = 5
     * head.next.next = head; 即 5 4
     * 而原本的 head.next 指向了 5 即 5 4 5
     * 我们需要切断 4 5 这条线 head.next = null;
     * 最后然后翻转后的头节点，即node 5 4 即可
     *
     * 递归三要素:
     *      * 1、终止条件；节点为单个时直接返回
     *      * 2、返回值：返回翻转后的链表头节点
     *      * 3、递归公式：将当前节点指向反转后的头节点
     * @param head
     * @return
     */
    public ListNode reverseListRecursion(ListNode head) {
        // 递归三要素：1、终止条件2、返回值3、递归公式
        if (head == null || head.next == null) {
            return head;
        }
        // 分治翻转剩下的节点，返回翻转后的头节点
        ListNode reverse = reverseList(head.next);
        // 在分治前head.next成为了翻转后链表的尾节点，衔接上当前头节点即可
        head.next.next = head;
        // 既然当前节点放到了尾部，那么该节点原本next也应该置空
        head.next = null;
        return reverse;
    }
}
