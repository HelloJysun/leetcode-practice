package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

import java.util.Stack;

/**
 * 二叉树的镜像
 *
 * @author json
 * @since 2022/2/26
 */
public class Practice27 {

    /**
     * 递归解法
     */
    public TreeNode solution(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
    }

    /**
     * 辅助栈解法：借助栈来实现递归，保存左右子节点，并交换，依次递进到子节点为null，再回溯处理
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

}
