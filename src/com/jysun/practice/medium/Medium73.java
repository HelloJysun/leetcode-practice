package com.jysun.practice.medium;

import com.jysun.practice.datastruct.Array;

/**
 * @author Jysun
 * @description 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 * @date 2021/3/21 10:13
 */
public class Medium73 {

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);
        System.out.println(Array.toString(matrix1));

        int[][] matrix2 = {{1, 0, 3}};
        setZeroesOpt(matrix2);
        System.out.println(Array.toString(matrix2));
    }

    public static void setZeroes(int[][] matrix) {
        int lenH = matrix.length;
        int lenV = matrix[0].length;
        boolean[] m = new boolean[lenH];
        boolean[] n = new boolean[lenV];
        // 遍历所有节点，将 0 位行标记
        for (int i = 0; i < lenH; i++) {
            for (int j = 0; j < lenV; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = n[j] = true;
                }
            }
        }
        for (int i = 0; i < lenH; i++) {
            for (int j = 0; j < lenV; j++) {
                if (m[i] || n[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroesOpt(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        // 用第一行，第一列充当标记数组，用两个临时变量充当第一行和第一列的单独标记
        boolean firstRow = false, firstColumn = false;
        // 第一列
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }
        // 第一行
        for (int i = 0; i < columnLength; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        // 遍历后续行和列，用第一行/第一列充当标记
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 根据标记替换
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 第一行替换0
        if (firstRow) {
            for (int i = 0; i < columnLength; i++) {
                matrix[0][i] = 0;
            }
        }
        // 第一列替换0
        if (firstColumn) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
