package com.jysun.practice.medium;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jysun
 * @description 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @date 2020/3/24 9:21
 */
public class Medium102 {

    public static void main(String[] args) {
        Medium102 obj = new Medium102();
        List<List<Integer>> res = obj.levelOrder(TreeNode.createSimpleBinaryTree());
        System.out.println(res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
