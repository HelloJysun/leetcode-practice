package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 提示：
 * 节点总数 <= 1000
 *
 * @author json
 * @since 2021/8/15
 */
public class Offer32_III {

    public static void main(String[] args) {
        Offer32_III obj = new Offer32_III();
        TreeNode root = TreeNode.createSimpleBinaryTree();
        System.out.println(obj.levelOrder(root));

        TreeNode root2 = TreeNode.createSimpleBinaryTree4();
        System.out.println(obj.levelOrder(root2));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> item = new LinkedList<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode node = queue.poll();
                // 从第一层开始算起，奇数层从左到右，偶数层从右到左
                if (res.size() % 2 == 0) item.addLast(node.val);
                else item.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(item);
        }
        return res;
    }
}
