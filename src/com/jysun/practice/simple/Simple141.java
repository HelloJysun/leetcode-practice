package com.jysun.practice.simple;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author Jysun
 * @description 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @date 2020/9/3 21:34
 */
public class Simple141 {

    public static void main(String[] args) {
        Simple141 obj = new Simple141();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        System.out.println(obj.hasCycle(head));
        ListNode node1 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        node1.next = node22;
        System.out.println(obj.hasCycle(node1));
        System.out.println(obj.hasCycleIn(head));
    }

    /**
     * 快慢指针:
     * 慢指针一次一步，快指针一次两步，因为快指针比慢指针快
     * 那么当慢指针进入环中时，快指针会赶上慢指针
     * 二者距离会逐渐缩小 n n-1 n-2 ... 3 2 1 0
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 环的入口：
     * head到入口的距离 == slow和fast相遇点到入口距离
     * 求环的结点数：一个是让快慢指针再走一圈计算，或者是让快慢指针再走一圈再次相遇也是环的长度
     * 链表长度 = 环的长度 + head到入口距离长度
     * 扩展问题：
     * 比如两个无环链表是否有相交的点，有的话求出来，可以拿A链表尾部连接上A的头，这样链表就转化为B链表的相交点即为A链表形成的环
     *
     * @param head
     * @return
     */
    public ListNode hasCycleIn(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode node1 = head;
        ListNode node2 = slow;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
