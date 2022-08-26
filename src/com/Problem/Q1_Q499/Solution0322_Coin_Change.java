package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution0322_Coin_Change s = new Solution0322_Coin_Change();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
    }

}
