package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return nums[0] == nums[1];
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, false);
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        Solution0416_Partition_Equal_Subset_Sum s = new Solution0416_Partition_Equal_Subset_Sum();
        System.out.println(s.canPartition(new int[]{1, 5, 11, 5}));
    }

}
