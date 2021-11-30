package com.jysun.practice.difficult;

import com.jysun.practice.datastruct.ListNode;

/**
 * K 个一组翻转链表
 * @author jysun
 * @since 2021/11/27
 */
public class Difficult25 {

    public static void main(String[] args) {
        Difficult25 obj = new Difficult25();
        ListNode head = ListNode.orderList(5);
        System.out.println(obj.reverseKGroup(head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            // 按k个一组分组
            ListNode tail = pre;
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            // 此时pre为上一分组的尾节点，tail为当前分组尾节点
            // 反转 head 到 tail
            ListNode next = tail.next;
            // 切断分组间的链
            tail.next = null;
            // pre指向反转后的头节点
            pre.next = reverse(head);
            // 移动到下一分组，续上链，head的头节点revere后就是尾节点
            head.next = next;
            pre = head;
            head = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }
}
