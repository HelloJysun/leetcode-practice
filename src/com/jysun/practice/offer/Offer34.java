package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 提示：
 * 节点总数 <= 10000
 *
 * @author jysun
 * @since 2021/8/24
 */
public class Offer34 {

    public static void main(String[] args) {
        Offer34 obj = new Offer34();
        TreeNode root = TreeNode.createMirrorTree();
        System.out.println(obj.pathSum(root, 7));
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> item) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && target == root.val) {
            item.add(root.val);
            res.add(new ArrayList<>(item));
            return;
        }
        item.add(root.val);
        if (root.left != null) {
            dfs(root.left, target - root.val, res, item);
            item.remove(item.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, target - root.val, res, item);
            item.remove(item.size() - 1);
        }
    }
}
