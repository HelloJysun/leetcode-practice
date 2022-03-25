package com.jysun.practice.category.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后
 *
 * @author jysun
 * @since 2022/3/24
 */
public class LC51 {

    public static void main(String[] args) {
        System.out.println(new LC51().solveNQueens(5));
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // 填充棋盘
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 一开始track为一行空格子，我们需要在某个位置替换为Q
     * 在递归时，需要判断并排除不合法的位置，如果合法就需要把当前位置替换为Q，再递归进入下一行，直到最后到达最后一行直接放进结果集
     * 在递归进入下一行返回后需要回溯跳到上一层判断，也就是撤销选择
     *
     * @param board 棋盘格
     * @param row   行数
     */
    public void backtrack(char[][] board, int row) {
        if (board.length == row) {
            // 走完所有棋盘格行了
            addRes(board);
            return;
        }
        // 透传进来的track是每一行棋盘格，所以需要遍历其列
        for (int col = 0; col < board.length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            // row col替换Q
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            // row col撤销.
            board[row][col] = '.';
        }
    }

    public void addRes(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        res.add(list);
    }

    /**
     * 需要验证board[row][col]这里是否可以放置🫅
     * 因为我们递归到第row行，row行后还没递归到直接不用判断
     * 所以我们只需要判断
     * 1、col列有没有Q
     * 2、row,col 的左上方即左边row，以及左斜线有没有Q
     * 3、row,col 的右上方即右边row，以及右斜线有没有Q
     *
     * @param board 棋盘格
     * @param row   行
     * @param col   列
     * @return 是否可放置
     */
    public boolean isValid(char[][] board, int row, int col) {
        // col列有没有Q
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        // 左上方，row,col收缩
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 右上方，row收缩，col扩张
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
