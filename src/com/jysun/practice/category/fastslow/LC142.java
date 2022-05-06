package com.jysun.practice.category.fastslow;

import com.jysun.practice.datastruct.ListNode;

/**
 * 环形链表 II
 *
 * @author jysun
 * @since 2022/5/6
 */
public class LC142 {

    /**
     * 既然可以通过快慢指针确定链表是否有环
     * fast和slow指针每走1步，二者相差1，所以可以确定slow和fast相遇时 fast走了2倍的slow步长
     * 假设环外长度为a，slow在环内走了b，环剩下长度为c，那么环长b + c
     * fast走了 a + n (b + c) + b
     * slow走了 a + b
     * 则有公式 a + n (b + c) + b = 2 (a + b)
     * 可推导出 a = n (b + c) - b = (n - 1)(b + c) + c
     * 由于 b + c 为环的一圈，所以可以理解为a = x圈 + c
     * 那从head出发的指针与相遇点出发的指针共同出发走a步后，即二者相遇即为环的入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        } while (fast != null && fast.next != null);
        return null;
    }
}
