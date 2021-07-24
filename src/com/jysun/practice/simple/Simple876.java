package com.jysun.practice.simple;

import com.jysun.practice.datastruct.ListNode;

/**
 * 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * @author json
 * @since 2021/7/24
 */
public class Simple876 {

    public static void main(String[] args) {
        Simple876 obj = new Simple876();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(obj.middleNode(node1));
    }

    public ListNode middleNode(ListNode head) {
        // 单节点直接返回
        if (head.next == null) {
            return head;
        }
        ListNode lo = head;
        ListNode hi = head;
        while (hi != null && hi.next != null) {
            lo = lo.next;
            hi = hi.next.next;
        }
        return lo;
    }
}
