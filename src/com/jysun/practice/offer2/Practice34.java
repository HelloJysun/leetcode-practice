package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
 *
 * @author json
 * @since 2022/2/27
 */
public class Practice34 {
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> item = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target, 0);
        return res;
    }

    /**
     * 书中解法：sum统计路径值，item存储路径所有节点值，前序遍历树，不是叶子节点就递归遍历左右子树。
     * 优化解法可以把sum去掉，改为target递减root.val一样效果
     */
    public void dfs(TreeNode root, int target, int sum) {
        if (root == null) return;
        sum += root.val;
        item.add(root.val);
        // 叶子节点且路径和等于target
        if (target == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(item));
        }
        // 不是叶子节点就遍历左右子树
        dfs(root.left, target, sum);
        dfs(root.right, target, sum);
        // 返回父节点前，需要删除路径上的当前节点
        item.pop();
    }
}
