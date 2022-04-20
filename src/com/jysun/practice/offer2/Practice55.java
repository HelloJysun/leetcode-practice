package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 二叉树的深度
 *
 * @author json
 * @since 2022/4/20
 */
public class Practice55 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createSimpleBinaryTree();
        System.out.println(new Practice55().maxDepth(root));
    }

    /**
     * 深度定义：根节点到叶子节点形成路径上最多节点长度
     * 所以可以不断递归左右子节点，每递归一次深度加1，取左右最大
     * 注意根节点为null时深度为0，否则初始化从1开始
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
