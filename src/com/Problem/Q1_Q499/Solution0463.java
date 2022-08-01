package com.Problem.Q1_Q499;

public class Solution0463 {
    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] helper = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                int x, y;
                if (grid[i][j] == 1) {
                    for (int[] ints : helper) {
                        x = i + ints[0];
                        y = j + ints[1];
                        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution0463 s = new Solution0463();
        s.islandPerimeter(new int[][]{{1, 1}});
    }
}
