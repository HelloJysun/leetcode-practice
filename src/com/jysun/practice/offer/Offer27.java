package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * @author jysun
 * @since 2021/8/16
 */
public class Offer27 {

    public static void main(String[] args) {
        Offer27 obj = new Offer27();
        TreeNode root = TreeNode.createSimpleBinaryTree();
        System.out.println(obj.mirrorTree(root));
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = mirrorTree(left);
        root.left = mirrorTree(right);
        return root;
    }
}
