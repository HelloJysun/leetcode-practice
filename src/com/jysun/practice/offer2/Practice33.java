package com.jysun.practice.offer2;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author json
 * @since 2022/2/27
 */
public class Practice33 {

    public static void main(String[] args) {
        int[] postorder = {4, 6, 7, 5};
        System.out.println(new Practice33().verifyPostorder(postorder));
    }

    public boolean verifyPostorder(int[] postorder) {
        return isPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean isPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        // 左子树
        int l = 0;
        for (; l < end; l++) {
            if (postorder[l] > root) {
                break;
            }
        }
        // 右子树
        int r = l;
        for (; r < end; r++) {
            if (postorder[r] < postorder[end]) {
                return false;
            }
        }
        return isPostorder(postorder, start, l - 1) && isPostorder(postorder, l, end - 1);
    }

    public boolean isPostorder1(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int l = start;
        while (postorder[l] < postorder[end]) {
            l++;
        }
        // 保存左子树边界
        int r = l;
        while (postorder[l] > postorder[end]) {
            l++;
        }
        return l == end && isPostorder1(postorder, start, r - 1) && isPostorder1(postorder, r, end - 1);
    }
}
