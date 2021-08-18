package com.jysun.practice.offer;

/**
 * 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * @author json
 * @since 2021/8/18
 */
public class Offer47 {

    public static void main(String[] args) {
        Offer47 obj = new Offer47();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(obj.maxValue(grid));
        int[][] grid2 = {{1}};
        System.out.println(obj.maxValue(grid2));
        System.out.println(obj.maxValueOpt(grid));
    }

    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        // dp[i][j]代表走到i，j位置的最大价值礼物
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        // 初始值为左上角
        dp[1][1] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i + 1][1] = dp[i][1] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[1][i + 1] = dp[1][i] + grid[0][i];
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < dp[0].length; j++) {
                // 向右或者向下
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i - 1][j - 1], dp[i][j - 1] + grid[i - 1][j - 1]);
            }
        }
        return dp[grid.length][grid[0].length];
    }

    /**
     * 转移方程:dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
     */
    public int maxValueOpt(int[][] grid) {
        int[] dp = new int[grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[grid[0].length];
    }
}
