package com.jysun.practice.medium;

/**
 * @author jysun
 * @since 2021/11/18
 */
public class Medium695 {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        Medium695 obj = new Medium695();
        System.out.println(obj.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        bfs(grid, 0, 0, visited, 0);
        return max;
    }

    private static int max = 0;
    /**
     * 递归三要素：
     * 终止条件：越界，i < 0 || j < 0 || i > grid.length || j > grid[0].length
     * 返回值：岛屿最大值
     * 处理：当前块为1累加，为0重置为0返回现有max
     */
    private void bfs(int[][] grid, int i, int j, boolean[][] visited, int area) {
        // 越界或已经访问过
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]) {
            return;
        }
        // 访问标记，当前为岛屿area + 1，并且max同area计算较大
        visited[i][j] = true;
        if (grid[i][j] == 1) {
            area++;
            max = Math.max(area, max);
        } else {
            // 当前没有岛屿，断层后area重置为0
            area = 0;
        }
        bfs(grid, i - 1, j, visited, area);
        bfs(grid, i + 1, j, visited, area);
        bfs(grid, i, j - 1, visited, area);
        bfs(grid, i, j + 1, visited, area);
    }
}
