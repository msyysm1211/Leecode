package com.Problem.Q1_Q499;

public class Solution0121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int opt[] = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            opt[i] = Math.max(opt[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return opt[prices.length - 1];
    }
}
