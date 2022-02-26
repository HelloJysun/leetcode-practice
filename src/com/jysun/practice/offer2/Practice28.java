package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 对称的二叉树
 *
 * @author json
 * @since 2022/2/26
 */
public class Practice28 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : dfs(root.left, root.right);
    }

    /**
     * 对称二叉树就是L的L == R的R 并且 L的R == R的L
     */
    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
