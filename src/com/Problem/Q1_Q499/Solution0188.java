package com.Problem.Q1_Q499;

public class Solution0188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n][2 * k];
        for (int i = 0; i < 2 * k; i = i + 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j - 1 < 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
                j++;
                dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i], dp[i - 1][j]);
            }
        }
        return dp[n - 1][2 * k - 1];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][3]);
    }

    public static void main(String[] args) {
        Solution0188 s = new Solution0188();
        System.out.println(s.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
