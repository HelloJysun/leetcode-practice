package com.jysun.practice.offer2;

/**
 * 矩阵中的路径
 *
 * @author json
 * @since 2022/2/17
 */
public class Practice12 {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从二维数组每个元素位置出发，从上下左右四个角度dfs访问，所到之处添加标记（不能重复利用）
                if (visit(board, word, 0, visited, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean visit(char[][] board, String word, int index, boolean[][] visited, int i, int j) {
        // 超出范围，访问过，不相等都直接返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        // 能走到这里说明当前元素相等，打上访问标记
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        // 移动word下标，访问上下左右四个角度，如果四条路都不通需要回溯
        boolean flag = visit(board, word, index + 1, visited, i - 1, j) || visit(board, word, index + 1, visited, i + 1, j)
                || visit(board, word, index + 1, visited, i, j - 1) || visit(board, word, index + 1, visited, i, j + 1);
        if (!flag) {
            visited[i][j] = false;
        }
        return flag;
    }
}
