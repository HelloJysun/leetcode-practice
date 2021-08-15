package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

import java.util.*;

/**
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 *
 * 提示：
 * 节点总数 <= 1000
 *
 * @author json
 * @since 2021/8/15
 */
public class Offer32_I {

    public static void main(String[] args) {
        Offer32_I obj = new Offer32_I();
        TreeNode root = TreeNode.createSimpleBinaryTree();
        System.out.println(Arrays.toString(obj.levelOrder(root)));

        TreeNode root2 = TreeNode.createSimpleBinaryTree4();
        System.out.println(Arrays.toString(obj.levelOrder2(root2)));
    }

    /**
     * 二叉树的层序遍历，一层一层的打印
     *
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }

    /**
     * 递归?
     */
    public int[] levelOrder2(TreeNode root) {
        dfs(root, 0);

        int[] arr = new int[k];
        int idx = 0;
        for (List<Integer> item : tmp) {
            for (Integer integer : item) {
                arr[idx++] = integer;
            }
        }
        return arr;
    }

    List<List<Integer>> tmp = new ArrayList<>();
    int k = 0;

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        // 每层新进一个集合
        List<Integer> item = new ArrayList<>();
        if (level + 1 > tmp.size()) {
            tmp.add(item);
        }
        // 具体层数的集合取出来塞进去
        tmp.get(level).add(root.val);
        // 计数器
        k++;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
