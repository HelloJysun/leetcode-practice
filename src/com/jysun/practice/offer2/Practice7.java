package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 重建二叉树
 *
 * @author json
 * @since 2022/2/16
 */
public class Practice7 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(new Practice7().buildTree(preorder, inorder));
    }

    /**
     * 前序遍历数组的首元素必为根节点，在中序遍历数组中，该值所在下标的左侧为其左子树，右侧为其右子树
     * 分别构造其左右子树，递归进行
     * 终止条件，数组为空
     * 根据根节点值在中序数组中找到分界点，依次递归处理左子树和右子树绑定在根节点上
     * 返回构建的树根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                              int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        // 首节点为根
        TreeNode head = new TreeNode(preorder[preorderStart]);
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == preorder[preorderStart]) {
                // i 为头节点所在inorder数组的下标
                // inorderStart到i-1为左子树，长度为i-inorderStart
                // i+1到inorderEnd为右子树，长度为inorderEnd+i+2
                int leftLen = i - inorderStart;
                head.left = buildTree(preorder, preorderStart + 1, preorderStart + leftLen, inorder, inorderStart, i - 1);
                head.right = buildTree(preorder, preorderStart + 1 + leftLen, preorderEnd, inorder, i + 1, inorderEnd);
                break;
            }
        }
        return head;
    }
}
