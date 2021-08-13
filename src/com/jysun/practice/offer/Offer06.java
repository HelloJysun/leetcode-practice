package com.jysun.practice.offer;

import com.jysun.practice.datastruct.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * @author jysun
 * @since 2021/8/11
 */
public class Offer06 {

    public static void main(String[] args) {
        Offer06 obj = new Offer06();
        ListNode head1 = ListNode.random(5);
        System.out.println(head1);
//        System.out.println(Arrays.toString(obj.reversePrint(head1)));
        System.out.println(Arrays.toString(obj.reversePrint2(head1)));

        ListNode head2 = ListNode.random(0);
        System.out.println(head2);
        System.out.println(Arrays.toString(obj.reversePrint(head2)));
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = tmp.val;
            tmp = tmp.next;
        }
        return res;
    }
}
