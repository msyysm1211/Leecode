package com.Problem.Q2000_Q2499;

public class Solution2428_Maximum_Sum_of_an_Hourglass {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                max = Math.max(max, helper(grid, i, j));
            }
        }
        return max;
    }

    int helper(int[][] grid, int x, int y) {
        int sum = 0;
        int[] xmove = {-1, 1};
        int[] ymove = {-1, 0, 1};
        sum += grid[x][y];
        for (int i : xmove) {
            for (int j : ymove) {
                int newx = x + i;
                int newy = y + j;
                sum += grid[newx][newy];
            }
        }
        return sum;
    }
}
