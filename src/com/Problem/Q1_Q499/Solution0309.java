package com.Problem.Q1_Q499;

public class Solution0309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);//持有收益=前面不持有收益-买入价格
            dp[i][1] = dp[i - 1][0] + prices[i];//卖=（前面收益-买入价格)+卖出价格
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    public static void main(String[] args) {
        Solution0309 s = new Solution0309();
        int t = s.maxProfit(new int[]{4, 2, 1});
    }
}
