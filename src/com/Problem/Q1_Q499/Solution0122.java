package com.Problem.Q1_Q499;

public class Solution0122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        return dp[n - 1];
    }
}
