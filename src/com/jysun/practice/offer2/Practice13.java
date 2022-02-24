package com.jysun.practice.offer2;

/**
 * 机器人的运动范围
 *
 * @author jysun
 * @since 2022/2/18
 */
public class Practice13 {

    public static void main(String[] args) {
        new Practice13().movingCount1(11, 1, 2);
    }

    /**
     * 这是错的
     * 机器人原地在[0,0]，如果k=2时，虽然[10,0] 1+0+0 <2但是它到不了[9,0]的位置，所以就不行
     * 还是要做回溯
     */
    public int movingCount(int m, int n, int k) {
        int res = 0;
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                // 因为小于等于100，所以直接取十位个位累加即可
                if ((i / 10 + i % 10 + j / 10 + j % 10) <= k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int movingCount1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return visit(visited, 0, 0, k);
    }

    public int visit(boolean[][] visited, int i, int j, int k) {
        // 超出边界、超出大小
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length
                || (i / 10 + i % 10 + j / 10 + j % 10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + visit(visited, i - 1, j, k) + visit(visited, i + 1, j, k) + visit(visited, i, j - 1, k) + visit(visited, i, j + 1, k);
    }
}
