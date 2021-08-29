package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @author json
 * @since 2021/8/29
 */
public class Offer55_I {

    public static void main(String[] args) {
        Offer55_I obj = new Offer55_I();
        TreeNode root = TreeNode.createSimpleBinaryTree();
        System.out.println(obj.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
