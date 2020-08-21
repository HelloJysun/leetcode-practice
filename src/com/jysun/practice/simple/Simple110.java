package com.jysun.practice.simple;

import com.jysun.practice.datastruct.TreeNode;

/**
 * @author Jysun
 * @description 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * @date 2020/8/18 14:54
 */
public class Simple110 {

    public static void main(String[] args) {
        Simple110 obj = new Simple110();
        System.out.println(obj.isBalanced(TreeNode.createSimpleBinaryTree()));
        System.out.println(obj.isBalanced(TreeNode.createSimpleBinaryTree3()));
        System.out.println(obj.isBalancedOpt(TreeNode.createSimpleBinaryTree()));
        System.out.println(obj.isBalancedOpt(TreeNode.createSimpleBinaryTree3()));
    }

    /**
     * 递归三要素：
     * 终止条件：root == null
     * 返回值：是否为平衡二叉树 - 左右子树是否为平衡树
     * 做什么：计算左右子树的高度并判断高度差是否不超过1
     *
     * 自顶向下的解法
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    /**
     * 计算高度
     *
     * @param root
     * @return
     */
    private int height(TreeNode root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * 自底向上的解法：
     * 由于自顶向下解法的每个结点的height被多次重复计算
     *
     * @param root
     * @return
     */
    public boolean isBalancedOpt(TreeNode root) {
        return heightOpt(root) != -1;
    }

    /**
     * 递归三要素:
     * 终止条件：root == null
     * 返回值：平衡返回树高度，不平衡返回-1
     * 做什么：判断左右子树是否平衡，再判断当前结点出发的树是否平衡
     *
     * @param root
     * @return 是平衡二叉树返回其树高度，否则返回-1
     */
    private int heightOpt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = heightOpt(root.left);
        int r = heightOpt(root.right);
        return l != -1 && r != -1 && Math.abs(l - r) <= 1 ? Math.max(l, r) + 1 : -1;
    }
}
