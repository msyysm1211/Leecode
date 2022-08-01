package com.Problem.Q1_Q499;

public class Solution0256 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n + 1][3];
        dp[1][0] = costs[0][0];
        dp[1][1] = costs[0][1];
        dp[1][2] = costs[0][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + costs[i - 1][0], dp[i - 1][2] + costs[i - 1][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + costs[i - 1][1], dp[i - 1][2] + costs[i - 1][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + costs[i - 1][2], dp[i - 1][1] + costs[i - 1][2]);
        }
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }

    public static void main(String[] args) {
        Solution0256 s = new Solution0256();
        int t = s.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
        System.out.println(t);
    }
}
