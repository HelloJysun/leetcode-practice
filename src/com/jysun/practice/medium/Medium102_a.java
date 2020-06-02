package com.jysun.practice.medium;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jysun
 * @description Medium102_a 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
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
 * @date 2020/5/13 7:41
 */
public class Medium102_a {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        Medium102_a obj = new Medium102_a();
        List<List<Integer>> res = obj.levelOrder(node3);
        System.out.println(res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                root = queue.poll();
                levelList.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            res.add(levelList);
        }
        return res;
    }
}
