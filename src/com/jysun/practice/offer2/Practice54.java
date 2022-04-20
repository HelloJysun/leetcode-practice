package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k大节点
 *
 * @author json
 * @since 2022/4/20
 */
public class Practice54 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinarySearchTree();
        System.out.println(new Practice54().kthLargest(root, 4));
        System.out.println(new Practice54().kthLargestOpt(root, 4));
    }

    /**
     * 二叉搜索树的中序遍历为递增数组，so直接中序遍历形成数组倒序取第k个元素即可
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(list.size() - k);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    int maxK = 0, cnt = 0;
    /**
     * 由于做了许多无用功，既然取第k个，那就从大到小遍历，即右根左得到就是倒序数组，而不是左根右的正序数组
     */
    public int kthLargestOpt(TreeNode root, int k) {
        dfs(root, k);
        return maxK;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        cnt++;
        if (cnt == k) {
            maxK = root.val;
            return;
        }
        dfs(root.left, k);
    }
}
