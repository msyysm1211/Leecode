package com.Problem.Q1_Q499;

public class Solution0325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        int l = 0;
        int r = 0;
        int sum = nums[0];
        while (r < nums.length && r >= l) {
            if (sum == k && r - l + 1 > max) {
                max = r - l + 1;
            }

        }
        return max;
    }
}
