package com.Problem.Q1_Q499;

public class Solution0276 {
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n];
    }

    public int numWays2(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int prepre = k;
        int pre = k * k;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = (pre + prepre) * (k - 1);
            prepre = pre;
            pre = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution0276 s = new Solution0276();
        int t = s.numWays2(7, 2);
        System.out.println(t);
    }
}
