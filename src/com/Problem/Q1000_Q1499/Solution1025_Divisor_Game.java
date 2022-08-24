package com.Problem.Q1000_Q1499;

public class Solution1025_Divisor_Game {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        dp[2] = true;
        dp[1] = false;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (dp[i - j] == false) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution1025_Divisor_Game s = new Solution1025_Divisor_Game();
        boolean t = s.divisorGame(5);
        System.out.println(t);
    }
}
