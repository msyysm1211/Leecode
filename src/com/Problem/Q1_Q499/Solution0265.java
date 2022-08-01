package com.Problem.Q1_Q499;

public class Solution0265 {
    public int minCostII(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m + 1][n];
        for (int i = 0; i < n; i++) {
            dp[1][i] = costs[0][i];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE / 2;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i - 1][k] + costs[i - 1][j]);
                    }
                }
                dp[i][j] = min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[m + 1][i], res);
        }
        return res;
    }
}
