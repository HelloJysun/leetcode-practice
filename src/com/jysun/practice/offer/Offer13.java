package com.jysun.practice.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author jysun
 * @since 2021/8/23
 */
public class Offer13 {

    public static void main(String[] args) {
        Offer13 obj = new Offer13();
        System.out.println(obj.movingCount(2, 3, 1));
        System.out.println(obj.movingCount(35, 37, 18));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, 0, 0, k, visited);
    }

    /**
     * 因为 m，n都位于 1 - 100，所以直接取 m / 10 + m % 10 就可得到数位和
     */
    private int dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || (i / 10 + i % 10 + j / 10 + j % 10) > k) {
            return 0;
        }
        visited[i][j] = true;
//        return dfs(m, n, i - 1, j, k, visited)
//                + dfs(m, n, i + 1, j, k, visited)
//                + dfs(m, n, i, j - 1, k, visited)
//                + dfs(m, n, i, j + 1, k, visited) + 1;
        // 提前判断边界，不累加
        int cnt = 0;
        if (i > 0) cnt += dfs(m, n, i - 1, j, k, visited);
        if (i < m - 1) cnt += dfs(m, n, i + 1, j, k, visited);
        if (j > 0) cnt += dfs(m, n, i, j - 1, k, visited);
        if (j < n - 1) cnt += dfs(m, n, i, j + 1, k, visited);
        return ++cnt;
    }

}
