package com.jysun.practice.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * @author jysun
 * @since 2021/8/11
 */
public class Offer35 {

    public static void main(String[] args) {
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        node0.next = node1;
        node0.random = node1;
        node1.random = node1;

        Offer35 obj = new Offer35();
        System.out.println(obj.copyRandomList(node0));
        System.out.println(obj.copyRandomListOpt(node0));
    }

    public Node copyRandomList(Node head) {
        // 先将原本val复制过来
        Node dummy = new Node(0);
        Node tmp1 = dummy;
        Node cur = head;
        // 原节点 - 新节点
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            tmp1.next = copy;
            tmp1 = tmp1.next;
            cur = cur.next;
        }
        // 此时dummy.next链表的val已复制完成，还差random随机指向
        Node tmp2 = dummy.next;
        Node cur2 = head;
        while (cur2 != null) {
            // 根据原有random节点取新映射的节点
            tmp2.random = map.get(cur2.random);
            tmp2 = tmp2.next;
            cur2 = cur2.next;
        }
        return dummy.next;
    }

    public Node copyRandomListOpt(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
            System.out.println(cur);
        }
        return null;
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
