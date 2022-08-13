package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution0322 s = new Solution0322();
        s.coinChange(new int[]{1, 2, 5}, 11);
    }
}
