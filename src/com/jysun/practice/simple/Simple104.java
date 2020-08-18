package com.jysun.practice.simple;

import com.jysun.practice.datastruct.TreeNode;

/**
 * @author Jysun
 * @description 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @date 2020/8/18 14:40
 */
public class Simple104 {

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
        Simple104 obj = new Simple104();
        System.out.println(obj.maxDepth(node3));
    }

    /**
     * 递归三要素：
     * 终止条件
     * 返回值
     * 每一层需要做什么
     *
     * 就求二叉树最大深度来说
     * 终止条件就是root==null，即空树
     * 返回值就是结点的深度
     * 每一层要做的就是计算左右子树的深度返回其较大值
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
