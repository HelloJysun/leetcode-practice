package com.jysun.practice.classify.tree;

import com.jysun.practice.datastruct.TreeNode;

/**
 * @author json
 * @since 2021/10/17
 */
public class Simple783 {

    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        // 最小差值一定是根节点和左右节点产生的
        return dfs(root, Integer.MAX_VALUE);
    }

    private int dfs(TreeNode root, int min) {
        if (root.left != null) {
            min = Math.min(root.val - root.left.val, min);
            dfs(root.left, min);
        }
        if (root.right != null) {
            min = Math.min(root.right.val - root.val, min);
            dfs(root.right, min);
        }
        return min;
    }
}
