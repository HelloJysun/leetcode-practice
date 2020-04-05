package com.jysun.practice.practice;

/**
 * @author Jysun
 * @description DynamicPrograming
 * @date 2020/4/5 13:28
 */
public class DynamicPrograming01Knapsack {

    public static void main(String[] args) {
        int W = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        DynamicPrograming01Knapsack obj = new DynamicPrograming01Knapsack();
        System.out.println(obj.dp01(W, wt, val));
    }

    /**
     * 01背包问题
     * 给定一个可装重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性
     * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在用这个背包装物品，问最多能装多少价值？
     *
     * demo1：
     * W = 4, N = 3
     * wt = [2, 1, 3]
     * val = [4, 2, 3]
     */
    private int dp01(int W, int[] wt, int[] val) {
        int N = wt.length;
        int[][] dp = new int[W + 1][N + 1];
        for (int i = 1; i <= W; i++) { // 容量
            for (int j = 1; j <= N; j++) { // 件数
                if (i < wt[j - 1]) { // 当前容量过小
                    dp[i][j] = dp[i][j - 1];
                } else { // 选或不选的问题
                    dp[i][j] = Math.max(val[j - 1] + dp[i - wt[j - 1]][j - 1], dp[i][j - 1]);
                }
            }
        }
        return dp[W][N];
    }
}
