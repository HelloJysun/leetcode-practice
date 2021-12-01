package com.jysun.practice.difficult;

import com.jysun.practice.datastruct.ListNode;

/**
 * @author jysun
 * @since 2021/11/30
 */
public class Difficult25_ {

    public static void main(String[] args) {
        ListNode head = ListNode.orderList(5);
        ListNode res = reverse1(head);
        System.out.println(res);

        ListNode head2 = ListNode.orderList(5);
        ListNode res2 = reverse2(head2);
        System.out.println(res2);

        ListNode head3 = ListNode.orderList(5);
        ListNode res3 = reverseKGroup(head3, 2);
        System.out.println(res3);
    }

    /**
     * 迭代法
     * 以头节点为起始节点，不断将节点插入到头节点前，并把头节点指向插入后的节点，直到遍历到尾节点，即next==null结束
     */
    public static ListNode reverse1(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            // 当前待插入节点
            ListNode node = cur.next;
            // 插入到head前，并将head指向它
            // 以1 2 3举例，先取出来2后，需要让1指向3，2再指向1
            cur.next = node.next;
            node.next = head;
            head = node;
        }
        return head;
    }

    /**
     * 递归法
     * 1234相当于处理234，相当于处理34，相当于处理4。
     * reverse后返回的是反转后的头节点即4，原本的head.next为2此时到了尾节点，头节点还是1，反转就是将2指向1
     * 1  和  432 处理 2要指向1，1原本指向2断开要不有环了
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    /**
     * k个一组反转，起始就是确定好每组的边界，然后分别反转即可，反转后要把后续的元素串上，而小于k个时说明后边就不用reverse了直接返回结果
     * 因为要k个一组反转，所有组与组之间要进行反转后的串起来关联上，也就是前一组的尾节点pre和下一组的头节点head要保存起来
     * reverseK个后pre.next = reverse头，reverse尾.next = head
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            // 保存下一组链表头，并断开。反转当前组链表
            ListNode next = tail.next;
            tail.next = null;
            pre.next = reverse1(pre.next);
            head.next = next;
            // 移动到下一组
            pre = head;
            head = next;
        }
        return dummy.next;
    }

}
