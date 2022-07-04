package com.Problem.Q500_Q999;

public class Solution0695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, DFS(grid, i, j));
            }
        }
        return ans;
    }

    int DFS(int[][] image, int i, int j) {
        if (i < 0 || j < 0 || i > image.length - 1 || j > image[0].length - 1 || image[i][j] != 1) {
            return 0;
        }
        image[i][j] = 0;
        int ans = 1;
        ans += DFS(image, i - 1, j);
        ans += DFS(image, i + 1, j);
        ans += DFS(image, i, j - 1);
        ans += DFS(image, i, j + 1);
        return ans;
    }
}
