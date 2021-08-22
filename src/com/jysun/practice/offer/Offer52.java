package com.jysun.practice.offer;

import com.jysun.practice.datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * @author json
 * @since 2021/8/21
 */
public class Offer52 {

    public static void main(String[] args) {
        ListNode headA4 = new ListNode(4);
        ListNode headA1 = new ListNode(1);

        ListNode headB5 = new ListNode(5);
        ListNode headB0 = new ListNode(0);
        ListNode headB1 = new ListNode(1);

        ListNode head8 = new ListNode(8);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        headA4.next = headA1;
        headA1.next = head8;
        head8.next = head4;
        head4.next = head5;

        headB5.next = headB0;
        headB0.next = headB1;
        headB1.next = head8;

        Offer52 obj = new Offer52();
        System.out.println(obj.getIntersectionNode(headA4, headB5));
        System.out.println(obj.getIntersectionNodeOpt1(headA4, headB5));
        System.out.println(obj.getIntersectionNodeOpt2(headA4, headB5));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 两只链表的差值，指针同一位置出发遍历
     */
    public ListNode getIntersectionNodeOpt1(ListNode headA, ListNode headB) {
        int al = 0, bl = 0;
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != null) {
            tmpA = tmpA.next;
            al++;
        }
        while (tmpB != null) {
            tmpB = tmpB.next;
            bl++;
        }
        // 差值，可正可负，d > 0说明A比B长，<0说明B比A长
        int diff = al - bl;
        if (diff > 0) {
            while (diff-- > 0) headA = headA.next;
        } else {
            while (diff++ < 0) headB = headB.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    /**
     * 从两条链表头节点出发
     * headA到达尾节点后，从headB头节点再次出发
     * headB到达尾节点后，从headA头节点再次出发
     * headA长度 a，headB长度 b，相交部分长度 c
     * 相当于A指针移动了 a + (b - c)，B指针移动了 b + (a - c) 到达相交点
     */
    public ListNode getIntersectionNodeOpt2(ListNode headA, ListNode headB) {
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA != null ? tmpA.next : headB;
            tmpB = tmpB != null ? tmpB.next : headA;
        }
        return tmpA;
    }
}
