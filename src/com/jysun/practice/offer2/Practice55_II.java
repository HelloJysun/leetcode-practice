package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 平衡二叉树
 *
 * @author json
 * @since 2022/4/20
 */
public class Practice55_II {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createSimpleBinaryTree();
        System.out.println(new Practice55_II().isBalanced(root));
        TreeNode falseRoot = TreeNode.createBinarySearchTree();
        System.out.println(new Practice55_II().isBalanced(falseRoot));
    }

    /**
     * 任意节点的左右子树高度差不超过1即为平衡二叉树
     * 所以我们可以求左右子树高度，判断差是否<=1
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        // 当前节点左右高度差小于等于1，求完左右子树再分别递归求剩下节点
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
