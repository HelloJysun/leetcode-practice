package com.jysun.practice.offer2;

import java.util.Arrays;

/**
 * 顺时针打印矩阵
 *
 * @author json
 * @since 2022/2/27
 */
public class Practice29 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(new Practice29().spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        // row为横坐标限制，col为纵坐标限制，x为横坐标，y为纵坐标
        int row = matrix[0].length - 1;
        int col = matrix.length - 1;
        int[] res = new int[(row + 1) * (col + 1)];
        int x = 0, y = 0, idx = 0;
        // 只要没到正中间就可以顺时针打印
        while (true) {
            // 从左到右，固定纵坐标
            for (int i = x; i <= row; i++) {
                res[idx++] = matrix[x][i];
            }
            if (++y > col) break;
            // 从上到下，固定横坐标
            for (int i = y; i <= col; i++) {
                res[idx++] = matrix[i][row];
            }
            if (--row < x) break;
            // 从右到左
            for (int i = row; i >= x; i--) {
                res[idx++] = matrix[col][i];
            }
            if (--col < y) break;
            // 从下到上
            for (int i = col; i >= y; i--) {
                res[idx++] = matrix[i][x];
            }
            if (++x > row) break;
        }
        return res;
    }
}
