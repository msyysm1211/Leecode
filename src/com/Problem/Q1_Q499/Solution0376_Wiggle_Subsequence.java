package com.Problem.Q1_Q499;

import java.util.Arrays;
import java.util.Map;

public class Solution0376_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[][] dp = new int[n][2];
        int max = 0;
        for (int[] ints : dp) {
            Arrays.fill(ints, 1);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = Math.max(dp[i - 1][1] + 1, dp[i - 1][0]);
            } else if (nums[i] < nums[i - 1]) {
                dp[i][1] = Math.max(dp[i - 1][0] + 1, dp[i - 1][1]);
            } else {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = dp[i - 1][0];
            }
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0376_Wiggle_Subsequence s = new Solution0376_Wiggle_Subsequence();
        System.out.println(s.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }

}
