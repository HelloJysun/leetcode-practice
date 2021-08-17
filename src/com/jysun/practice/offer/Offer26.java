package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *
 * 给定的树 B：
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 限制：
 * 0 <= 节点个数 <= 10000
 *
 * @author jysun
 * @since 2021/8/16
 */
public class Offer26 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node3.left = node4;
        node3.right = node5;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node4.left = node1;
        node4.right = node2;

        TreeNode node4_ = new TreeNode(4);
        TreeNode node1_ = new TreeNode(1);
        node4_.left = node1_;

        Offer26 obj = new Offer26();
        System.out.println(obj.isSubStructure(node3, node4_));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 递归三要素
     * 终止条件：A null就不是子树，B null 就是子树，A B null也是子树
     * 返回值：返回是否是子树
     * 拆解递归：根节点相同对比左右子树
     */
    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
