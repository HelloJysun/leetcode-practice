package com.jysun.practice.offer2;

/**
 * 复杂链表的复制
 *
 * @author json
 * @since 2022/2/28
 */
public class Practice35 {
    public static void main(String[] args) {

    }

    /**
     * 既然要维护新旧节点的映射，倒不如将新旧节点相邻绑定，这样就可以原地解决
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 复制每个节点接到next上
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        // random引用
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                // 新旧相邻：当前节点复制的节点是cur.next，当前节点的random节点的下一个肯定也是复制节点的random
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分新旧链表
        cur = head;
        // 复制链表的头
        Node newHead = head.next;
        Node curr = newHead;
        while (curr.next != null) {
            cur.next = cur.next.next;
            curr.next = curr.next.next;
            cur = cur.next;
            curr = curr.next;
        }
        // 这一步不可少：原链表尾节点此时仍指向新链表尾
        cur.next = null;
        return newHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
