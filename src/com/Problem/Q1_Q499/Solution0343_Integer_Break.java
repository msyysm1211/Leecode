package com.Problem.Q1_Q499;

public class Solution0343_Integer_Break {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i - j] * j, (i - j) * j), dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution0343_Integer_Break s = new Solution0343_Integer_Break();
        System.out.println(s.integerBreak(10));
    }

}
