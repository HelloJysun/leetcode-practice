package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * @author jysun
 * @since 2021/8/16
 */
public class Offer28 {

    public static void main(String[] args) {
        Offer28 obj = new Offer28();
        TreeNode root = TreeNode.createMirrorTree();
        System.out.println(obj.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    /**
     * 递归三要素
     * 终止条件：左右节点null，其中一个null
     * 返回值：返回当前左右子树是否对称，即当前节点和左右子树
     * 干什么：两个节点相等时，判断左节点的左子树和右节点的右子树，左节点的右子树和右节点的左子树是否相等
     */
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}
