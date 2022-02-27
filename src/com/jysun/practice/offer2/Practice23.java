package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.ListNode;

/**
 * 链表中环的入口节点
 *
 * @author json
 * @since 2022/2/27
 */
public class Practice23 {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        System.out.println(new Practice23().detectCycle(node3));
    }

    /**
     * 快慢指针同时从head出发，slow走一步，fast走两步。
     * 如果有环则fast肯定能追上slow
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 比较节点而不是值
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找环形链表入口。结合上边的快慢指针，二者相遇肯定是在环内，那如果二者接着往下走二者肯定会再次相遇在第一次相遇的地方
     * 但slow指针走过的路其实就可以得知环的长度n了，此时再次从head出发，fast先走n步，slow flow每次一步最终相遇就是入口
     * 这里其实就利用了整个链表节点个数以及组成环的节点个数这两个参数，跟倒数第k个节点一个意思。
     * 快指针先走了环节点个数n步后，慢指针和快指针同时走了x步后相遇后其实就是整个链表节点个数c = x + n
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 此时第一次相遇，接走往下走通过slow计算环的节点数n
            if (slow == fast) {
                // 这里其实已经不需要在计算n了，因为fast已经比slow快了一圈，直接重置到head就完事了
                slow = head;
//                int n = 1;
//                while (slow.next != fast) {
//                    slow = slow.next;
//                    n++;
//                }
//                slow = head;
//                fast = head;
//                while (n-- > 0) {
//                    fast = fast.next;
//                }
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
