package com.jysun.practice.category.fastslow;

import com.jysun.practice.datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**ø
 * 环形链表
 *
 * @author jysun
 * @since 2022/5/5
 */
public class LC141 {

    public static void main(String[] args) {
        ListNode head = ListNode.random(5);
        System.out.println(new LC141().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        return head != null;
    }

    /**
     * 快慢指针
     * 确保fast比slow步进大即可
     */
    public boolean hasCycleOpt(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        } while (fast != null && fast.next != null);
        return false;
    }
}
