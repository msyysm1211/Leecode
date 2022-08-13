package com.Problem.Q1_Q499;

public class Solution0123 {
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

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sell1 = 0;
        int sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(buy1 + prices[i], sell1);
            buy2 = Math.max(sell1 - prices[i], buy2);
            sell2 = Math.max(buy2 + prices[i], sell2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        Solution0123 s = new Solution0123();
        System.out.println(s.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}
