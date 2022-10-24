package com.Problem.Q500_Q999;

public class Solution0714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0] - fee;
        int sell = 0;
        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(buy + prices[i], sell);
        }
        return sell;
    }
}
