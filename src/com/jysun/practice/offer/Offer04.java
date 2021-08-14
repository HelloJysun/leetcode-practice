package com.jysun.practice.offer;

/**
 * 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true
 * 给定 target = 20，返回 false。
 *
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * @author json
 * @since 2021/8/14
 */
public class Offer04 {

    public static void main(String[] args) {
        int[] row1 = {1,   4,  7, 11, 15};
        int[] row2 = {2,   5,  8, 12, 19};
        int[] row3 = {3,   6,  9, 16, 22};
        int[] row4 = {10, 13, 14, 17, 24};
        int[] row5 = {18, 21, 23, 26, 30};
        int[][] matrix = {row1, row2, row3, row4, row5};
        Offer04 obj = new Offer04();
        System.out.println(obj.findNumberIn2DArray(matrix, 5));
        System.out.println(obj.findNumberIn2DArray(matrix, 20));

        int[][] matrix1 = {{-5}};
        System.out.println(obj.findNumberIn2DArray(matrix1, -5));
    }

    /**
     * 顺序查找
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1, j = 0, j_len = matrix[0].length;
        while (i >= 0 && j < j_len) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
