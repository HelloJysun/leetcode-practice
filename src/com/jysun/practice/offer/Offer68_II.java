package com.jysun.practice.offer;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @author json
 * @since 2021/8/29
 */
public class Offer68_II {

    public static void main(String[] args) {
        Offer68_II obj = new Offer68_II();
        TreeNode root = TreeNode.createSimpleBinaryTree();
        TreeNode p = root.left;
        TreeNode q = p.left;
        System.out.println(obj.lowestCommonAncestor(root, p, q));
    }

    /**
     * 和二叉搜索树相比，该题无法利用数值比对左子树还有右子树
     * 只能通过 dfs 搜索左右子树，比对值
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 根节点为null直接就是，根节点和p、q相等时，说明根节点就是祖先
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 去左右子树找祖先后，左子树为null说明没找到则在右子树，同理
        if (left == null) return right;
        if (right == null) return left;
        // 左右子树均不为null那就是根节点了
        return root;
    }
}
