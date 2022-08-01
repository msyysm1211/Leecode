package com.Problem.Q1_Q499;

public class Solution0213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        int max = 0;
        int max1 = helper(nums, 1, n - 1);
        int max2 = helper(nums, 0, n - 2);
        return Math.max(max1, max2);
    }


    int helper(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start + 1], nums[start]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(second, nums[i] + first);
            first = temp;
        }
        return second;
    }

    //    int helper(int[] nums, int start, int end) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            dp[i] = nums[i];
//        }
//        for (int i = start; i <= end; i++) {
//            for (int j = 2; j <= i; j++) {
//                if (i - j >= start) {
//                    dp[i] = Math.max(dp[i], Math.max(dp[i - 1], dp[i - j] + nums[i]));
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }
    public static void main(String[] args) {
        Solution0213 s = new Solution0213();
        int[] nums = new int[]{4, 1, 2, 7, 5, 3, 1};
        System.out.println(s.rob(nums));
    }
}
