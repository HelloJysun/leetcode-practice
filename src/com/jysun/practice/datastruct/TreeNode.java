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
     * 创建一个普通的二叉树
     *
     * @return
     */
    public static TreeNode createSimpleBinaryTree() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        return node3;
    }

    /**
     * 创建一个普通的二叉树
     *
     * @return
     */
    public static TreeNode createSimpleBinaryTree4() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        return node1;
    }

    /**
     * 创建一个普通的二叉树
     *
     * @return
     */
    public static TreeNode createSimpleBinaryTree3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node1_l = new TreeNode(2);
        TreeNode node1_r = new TreeNode(2);
        TreeNode node2_l = new TreeNode(3);
        TreeNode node2_r = new TreeNode(3);
        TreeNode node3_l = new TreeNode(4);
        TreeNode node3_r = new TreeNode(4);
        node1.left = node1_l;
        node1.right = node1_r;
        node1_l.left = node2_l;
        node1_l.right = node2_r;
        node2_l.left = node3_l;
        node2_l.right = node3_r;
        return node1;
    }

    /**
     * 创建一个普通的二叉树
     *
     * @return
     */
    public static TreeNode createSimpleBinaryTree2() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        node3.left = node9;
        return node3;
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

    /**
     * 创建一个镜像对称的二叉树
     *
     * @return
     */
    public static TreeNode createMirrorTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node1_l = new TreeNode(2);
        TreeNode node1_r = new TreeNode(2);
        TreeNode node2_l3 = new TreeNode(3);
        TreeNode node2_r4 = new TreeNode(4);
        TreeNode node2_l4 = new TreeNode(4);
        TreeNode node2_r3 = new TreeNode(3);
        node1.left = node1_l;
        node1.right = node1_r;
        node1_l.left = node2_l3;
        node1_l.right = node2_l4;
        node1_r.left = node2_r4;
        node1_r.right = node2_r3;
        return node1;
    }
}
