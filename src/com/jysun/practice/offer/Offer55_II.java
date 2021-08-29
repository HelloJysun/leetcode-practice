package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 限制：
 * 0 <= 树的结点个数 <= 10000
 *
 * @author json
 * @since 2021/8/29
 */
public class Offer55_II {

    public static void main(String[] args) {
        Offer55_II obj = new Offer55_II();
        TreeNode root = TreeNode.createBinarySearchTree();
        System.out.println(obj.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
