package com.jysun.practice.offer;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *
 * @author jysun
 * @since 2021/8/23
 */
public class Offer12 {

    public static void main(String[] args) {
        Offer12 obj = new Offer12();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(obj.exist(board, "ABCCED"));
        char[][] board2 = {{'a'}};
        System.out.println(obj.exist(board2, "ab"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * board[i][j] == word.charAt(index)时四个方向走，注意边界和访问标记
     */
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length  // 超过边界
                || board[i][j] != word.charAt(index) || visited[i][j]) { // 不等
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = dfs(board, word, visited, i + 1, j, index + 1) // 下
                || dfs(board, word, visited, i - 1, j, index + 1) // 上
                || dfs(board, word, visited, i, j + 1, index + 1) // 右
                || dfs(board, word, visited, i, j - 1, index + 1);// 左
        visited[i][j] = false;
        return res;
    }
}
