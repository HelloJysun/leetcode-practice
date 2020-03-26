package com.jysun.practice.practice;

import com.jysun.practice.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jysun
 * @description BinarySearchTree
 * @date 2020/3/26 7:39
 */
public class BinarySearchTree {

    TreeNode root = TreeNode.createBinarySearchTree();

    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        // 查
        TreeNode res = obj.search(19);
        System.out.println(res);
        // 插
        TreeNode node55 = new TreeNode(55);
        obj.insert(node55);
        System.out.println(obj.root);
        // 删
        boolean delete = obj.delete(50);
        System.out.println(obj.root);
        // 输出
        List<Integer> inorder = obj.inorderTraversal(obj.root);
        System.out.println(inorder);

    }

    public TreeNode search(int data) {
        TreeNode res = root;
        while (res != null) {
            if (data == res.val) {
                return res;
            } else if (data < res.val) {
                res = res.left;
            } else if (data > res.val) {
                res = res.right;
            }
        }
        return null;
    }

    public void insert(TreeNode node) {
        TreeNode cur = root;
        while (cur != null) {
            if (node.val > cur.val) {// 插入节点值大于当前节点则遍历右子树
                if (cur.right == null) {// 左子树为空直接插入返回
                    cur.right = node;
                    return;
                }
                cur = cur.right;
            } else if (node.val < cur.val) {// 插入节点值小于当前节点则遍历左子树
                if (cur.left == null) {
                    cur.left = node;
                    return;
                }
                cur = cur.left;
            }
        }
    }

    /**
     * 删除操作需要分三种情况：
     * 1、删除的是叶子节点，那么直接置空即可。或者将其标记为删除状态、
     * 2、删除的节点只有一个子节点，那么将删除节点的父节点直接指向删除节点的子节点即可
     * 3、删除的节点有两个子节点，就需要找到删除节点中右子树最小节点放在删除节点处，并删除这个最小节点
     *
     * @param data
     */
    public boolean delete(int data) {
        TreeNode res = root;
        TreeNode par = null;
        while (res != null) {
            if (data == res.val) {// 找到了待删除元素
                // 1、无子节点
                if (res.left == null && res.right == null) {
                    if (par.left == res) {
                        par.left = null;
                    } else if (par.right == res) {
                        par.right = null;
                    } else if (par == null) {// 删除的是根节点root
                        root = null;
                    }
                } else if (res.left != null && res.right != null) {
                    // 3、2个子节点
                    TreeNode min = res.right;
                    TreeNode minPar = res;
                    while (min.left != null) {
                        minPar = min;
                        min = min.left;
                    }
                    res.val = min.val;
                    minPar.left = min.right;
                } else if (res.left != null || res.right != null) {
                    // 2、1个子节点
                    if (res.left != null) {
                        if (par.left == res) {
                            par.left = res.left;
                        } else if (par.right == res) {
                            par.right = res.left;
                        } else if (par == null) {
                            root = res.left;
                        }
                    } else if (res.right != null) {
                        if (par.left == res) {
                            par.left = res.right;
                        } else if (par.right == res) {
                            par.right = res.right;
                        } else if (par == null) {
                            root = res.right;
                        }
                    }
                }
                return true;
            } else if (data < res.val) {
                par = res;
                res = res.left;
            } else if (data > res.val) {
                par = res;
                res = res.right;
            }
        }
        return false;// 没找到待删除元素
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}
