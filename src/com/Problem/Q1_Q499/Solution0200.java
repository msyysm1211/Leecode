package com.Problem.Q1_Q499;

public class Solution0200 {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] ints : move) {
            int movex = x + ints[0];
            int movey = y + ints[0];
            dfs(grid, movex, movey);
        }
    }
}
