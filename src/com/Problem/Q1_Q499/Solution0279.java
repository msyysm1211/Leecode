package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution0279 s = new Solution0279();
        s.numSquares(12);
    }
}
