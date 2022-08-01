package com.Problem.Q500_Q999;

public class Solution0695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int cnt = 1;
        cnt += dfs(grid, x + 1, y);
        cnt += dfs(grid, x - 1, y);
        cnt += dfs(grid, x, y + 1);
        cnt += dfs(grid, x, y - 1);
        return cnt;
    }
}
