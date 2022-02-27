package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 III
 *
 * @author json
 * @since 2022/2/27
 */
public class Practice32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> item = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if ((level & 1) == 1) {
                    item.addLast(node.val);
                } else {
                    item.addFirst(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(item);
            level++;
        }
        return res;
    }
}
