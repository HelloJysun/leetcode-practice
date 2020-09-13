package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * @date 2020/9/13 10:25
 */
public class Medium79 {

    public static void main(String[] args) {
        Medium79 obj = new Medium79();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(obj.exist(board, "ABCCED"));
        System.out.println(obj.exist(board, "ABCB"));
        System.out.println(obj.exist(board, "ABCESEEEFS"));
    }

    /**
     * 从每一点出发，深度搜索
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] marked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    /**
     * 递归三要素
     * 终止条件：
     * 返回值：
     * 做什么：
     *
     * @param x
     * @param y
     * @return
     */
    public boolean dfs(char[][] board, int x, int y, String word, int index, boolean[][] marked) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        // 当前字母匹配成功开始上下左右搜索
        if (board[x][y] == word.charAt(index)) {
            marked[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                    continue;
                }
                if (!marked[newX][newY] && dfs(board, newX, newY, word, index + 1, marked)) {
                    return true;
                }
            }
            marked[x][y] = false;
        }
        return false;
    }
}
