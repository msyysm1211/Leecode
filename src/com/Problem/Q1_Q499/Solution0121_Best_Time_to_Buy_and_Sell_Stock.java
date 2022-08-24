package com.Problem.Q1_Q499;

public class Solution0121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);
            min = Math.min(min, prices[i]);
        }
        return dp[n - 1];
    }
}
