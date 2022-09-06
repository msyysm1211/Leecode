package com.Problem.Q1000_Q1499;

public class Solution1155_Number_of_Dice_Rolls_With_Target_Sum {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j - l >= 0) {
                        dp[i][j] = (dp[i - 1][j - l] + dp[i][j]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        Solution1155_Number_of_Dice_Rolls_With_Target_Sum s = new Solution1155_Number_of_Dice_Rolls_With_Target_Sum();
        int t = s.numRollsToTarget(2, 6, 7);
        System.out.println(t);
    }
}
