package com.jysun.practice.offer2;

/**
 * 二叉搜索树与双向链表
 *
 * @author json
 * @since 2022/5/11
 */
public class Practice36 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node1;
        node2.right = node3;
        node4.left = node2;
        node4.right = node5;

        System.out.println(new Practice36().treeToDoublyList(node4));
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        // 形成双向链表的关键在于将左子树的最大值与根节点相连、右子树的最小值与根节点相连
        dfs(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    // 可以理解为这两个引用就是当前中序遍历形成的链表的表头和表尾，表头只是为了做暂时记录使用，表尾是为了在遍历时不断形成双向链表
    // 当前节点的前继节点（即左子树的链表表尾）
    Node prev;
    // 当前节点左子树的链表表头
    Node head;

    /**
     * 由于输入为二叉搜索树，需要转换为排序的双向链表
     * 所以可以以中序遍历(有序)方式来处理
     * 核心代码
     * dfs(root.left)
     * // 中间部分主要是将每个节点与前继节点做引用指向，然后再更新前继节点为当前节点即可
     * // 只是一开始初始化时由于prev==null，所以需要特殊处理并保存整个链表的表头head
     * prev.right = root
     * root.left = prev
     * prev = root
     * dfs(root.right)
     */
    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // 初始化状态，此时递归到了中序遍历的第一个节点也就是表头。用一个全局变量保存该引用后续都不会改变了
        // 一开始两个引用其实都是null 用head判断也可以
        if (prev == null) {
            head = root;
        } else {
            // 前继节点不为null时，需要与当前节点相连
            prev.right = root;
        }
        root.left = prev;
        // 由于是中序遍历，所以节点有序每次遍历后都需要把前继节点更新为当前节点也就是链表的最后一个节点
        prev = root;
        dfs(root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
