package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第K大个节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author jysun
 * @since 2021/8/24
 */
public class Offer54 {

    public static void main(String[] args) {
        Offer54 obj = new Offer54();
        TreeNode root = TreeNode.createBinarySearchTree();
        System.out.println(obj.kthLargest(root, 3));
        System.out.println(obj.kthLargestOpt(root, 3));
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root, k);
        return list.get(k - 1);
    }

    private void dfs(List<Integer> list, TreeNode root, int k) {
        if (root == null) {
            return;
        }
        // 右 根 左 为从大到小的遍历方式
        dfs(list, root.right, k);
        list.add(root.val);
        k--;
        if (k == 0) {
            return;
        }
        dfs(list, root.left, k);
    }

    int max = 0, cnt = 0;
    public int kthLargestOpt(TreeNode root, int k) {
        dfsOpt(root, k);
        return max;
    }

    /**
     * 从右 根 左遍历方式从大到小取数，一旦取到第k个直接返回即可
     */
    private void dfsOpt(TreeNode root, int k) {
        if (root.right != null) dfsOpt(root.right, k);
        if (++cnt == k) {
            max = root.val;
            return;
        }
        if (root.left != null) dfsOpt(root.left, k);
    }
}
