package com.Problem.Q1_Q499;

public class Solution0263 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        int p2 = 1, p3 = 1, p5 = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = dp[p2] * 2;
            int num2 = dp[p3] * 3;
            int num3 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);
            if (dp[i] == num1) {
                p2++;
            }
            if (dp[i] == num2) {
                p3++;
            }
            if (dp[i] == num3) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution0263 s = new Solution0263();
        System.out.println(s.nthUglyNumber(10));
    }
}
