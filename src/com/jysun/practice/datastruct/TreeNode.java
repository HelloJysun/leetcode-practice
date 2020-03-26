package com.jysun.practice.datastruct;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 创建一个二叉查找树
     *
     * @return root
     */
    public static TreeNode createBinarySearchTree() {
        TreeNode node33 = new TreeNode(33);
        TreeNode node17 = new TreeNode(17);
        TreeNode node50 = new TreeNode(50);
        node33.left = node17;
        node33.right = node50;
        TreeNode node13 = new TreeNode(13);
        TreeNode node18 = new TreeNode(18);
        node17.left = node13;
        node17.right = node18;
        TreeNode node34 = new TreeNode(34);
        TreeNode node58 = new TreeNode(58);
        node50.left = node34;
        node50.right = node58;
        node13.right = new TreeNode(16);
        TreeNode node25 = new TreeNode(25);
        node18.right = node25;
        TreeNode node51 = new TreeNode(51);
        TreeNode node66 = new TreeNode(66);
        node58.left = node51;
        node58.right = node66;
        TreeNode node19 = new TreeNode(19);
        TreeNode node27 = new TreeNode(27);
        node25.left = node19;
        node25.right = node27;
        return node33;
    }
}
