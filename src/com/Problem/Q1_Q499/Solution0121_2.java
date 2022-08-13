package com.Problem.Q1_Q499;

public class Solution0121_2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);
            min = Math.min(prices[i], min);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution0121_2 s = new Solution0121_2();
        int t = s.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(t);
    }
}
