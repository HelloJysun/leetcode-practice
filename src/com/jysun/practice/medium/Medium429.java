package com.jysun.practice.medium;

import com.jysun.practice.datastruct.Node;

import java.util.*;

/**
 * @author Jysun
 * @description N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *      1
 *  3   2   4
 *5  6
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 * @date 2020/3/24 9:21
 */
public class Medium429 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> child3 = new ArrayList<Node>(){{add(node5);add(node6);}};
        List<Node> child1 = new ArrayList<Node>(){{add(node3);add(node2);add(node4);}};
        node1.children = child1;
        node3.children = child3;

        Medium429 obj = new Medium429();
        List<List<Integer>> res = obj.levelOrder(node1);
        System.out.println(res);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                level.add(root.val);
                if (root.children != null) {
                    queue.addAll(root.children);
                }
            }
            res.add(level);
        }
        return res;
    }
}
