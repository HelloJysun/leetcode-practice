package com.jysun.practice.offer2;

import com.jysun.practice.datastruct.TreeNode;

/**
 * 树的子结构
 *
 * @author json
 * @since 2022/2/26
 */
public class Practice26 {

    public static void main(String[] args) {
        TreeNode A = TreeNode.array2Tree(new int[]{10, 12, 6, 8, 3, 11});
        TreeNode B = TreeNode.array2Tree(new int[]{10, 12, 6});
        System.out.println(new Practice26().isSubStructure(A, B));
    }

    /**
     * 由于约定了空树不是任意一棵树的子树！！！
     * 所以下边B == null就不能return true，需要再单独抽一个方法进行特殊情况递归
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        // 当前元素相等时，可以分别比较AB的左右子树或者递归判断A的左右子树与B树
        if (A.val == B.val) {
            return isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right)
                    || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        // 当前元素不相等时，就直接递归判断A的左右子树与B树了
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean solution(TreeNode A, TreeNode B) {
        return A != null && B != null && (dfs(A, B) || solution(A.left, B) || solution(A.right, B));
    }

    /**
     * 因为上边已经有个A.val == B.val所以这里递归进来时，已经可以确认了B不是空树。但递归时，B为null已经可以判断B树其他位置
     * 如果B树不为null，A树为null时或者二者不等就说明不是子树了，等于时就要分别比对各自的左右子树
     */
    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
