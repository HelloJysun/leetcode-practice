package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

import java.util.*;

/**
 * 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 提示：
 * 节点总数 <= 1000
 *
 * @author json
 * @since 2021/8/15
 */
public class Offer32_II {

    public static void main(String[] args) {
        Offer32_II obj = new Offer32_II();
        TreeNode root = TreeNode.createSimpleBinaryTree();
        System.out.println(obj.levelOrder(root));
        System.out.println(obj.levelOrder2(root));
    }

    /**
     * 每一层用一个集合保存。层序遍历时通过通过保存上一层的节点，并从左到右处理
     * 每次都是将当前层出队，并将节点数据保存，再将下一层的数据入队
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(item);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level + 1 > res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}
