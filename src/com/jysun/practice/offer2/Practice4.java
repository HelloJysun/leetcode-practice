package com.jysun.practice.offer2;

/**
 * 二维数组中的查找
 *
 * @author jysun
 * @since 2022/2/15
 */
public class Practice4 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean solution = new Practice4().solution2(matrix, 21);
        System.out.println(solution);
    }

    public boolean solution(int[][] matrix, int target) {
        return dfs(matrix, target, 0, 0);
    }

    /**
     * 如果矩阵过大，递归太深，会超时，也有可能会栈溢出
     */
    public boolean dfs(int[][] matrix, int target, int i, int j) {
        if (i == matrix.length || j == matrix[0].length || target < matrix[i][j]) {
            return false;
        }
        if (target == matrix[i][j]) {
            return true;
        }
        return dfs(matrix, target, i + 1, j) || dfs(matrix, target, i, j + 1);
    }

    /**
     * 从左上角开始，向右递增，向下递增。无法抉择
     * 从左下角开始，向上递减，向右递增。🉑️
     * 从右上角开始，向下递增，向左递减。🉑️
     */
    public boolean solution2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}