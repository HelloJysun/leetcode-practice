package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 *
 * @author json
 * @since 2022/3/15
 */
public class Practice52 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        headA.next = node2;
        node2.next = node3;
        ListNode headB = new ListNode(4);
        ListNode node5 = new ListNode(5);
        headB.next = node5;
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node3.next = node6;
        node5.next = node6;
        node6.next = node7;

        System.out.println(new Practice52().getIntersectionNode(headA, headB));
        System.out.println(new Practice52().getIntersectionNodeStack(headA, headB));
        System.out.println(new Practice52().getIntersectionNodeDouble(headA, headB));
    }

    /**
     * 笨方法：一次遍历存储某条链表节点，二次遍历判断是否含原本遍历链表节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curA = headA;
        while (curA != null) {
            set.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB != null) {
            if (set.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

    /**
     * 书本解法：存储到栈里，然后逆序前x个节点都相等，一旦不等时前一个节点就是公共节点
     * 之所以需要栈是因为想同时遍历到栈的尾节点，那么我们一旦直到较长链表比较短链表长多少个节点就可以在长链表上放置快指针，短链表慢指针同时出发即可
     */
    public ListNode getIntersectionNodeStack(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            stackA.push(curA);
            curA = curA.next;
        }
        while (curB != null) {
            stackB.push(curB);
            curB = curB.next;
        }
        ListNode res = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode valueA = stackA.pop();
            ListNode valueB = stackB.pop();
            if (valueA != valueB) {
                return res;
            }
            res = valueA;
        }
        return res;
    }

    /**
     * 尝试将A链表后拼上B链表，B链表后边拼上A链表，举例 12367、4567
     * 123674567
     * 456712367
     * 刚好遍历到第二轮时在6处相遇。
     * 假设共同长度有n，A链表长度有a，B链表长度有b。那么拼接上后，A链表有a+b，B链表有b+a，二者在a+b-n处相遇
     */
    public ListNode getIntersectionNodeDouble(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }
}
