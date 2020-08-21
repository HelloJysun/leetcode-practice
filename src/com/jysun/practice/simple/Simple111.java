package com.jysun.practice.simple;

import com.jysun.practice.datastruct.TreeNode;

/**
 * @author Jysun
 * @description 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * @date 2020/8/21 10:31
 */
public class Simple111   {

    public static void main(String[] args) {
        Simple111 obj = new Simple111();
        System.out.println(obj.minDepth(TreeNode.createSimpleBinaryTree()));
        System.out.println(obj.minDepth(TreeNode.createSimpleBinaryTree2()));
    }

    /**
     * 递归三要素
     * 终止条件：root == null，左节点null以右结点作为其深度，右结点null以左节点作为其深度。典型例子根节点3左节点为9深度应该是2，而不是1
     * 返回值：当前结点的深度
     * 做什么：比较左右子树深度，返回其较小值
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
