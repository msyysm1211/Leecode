package com.Problem.Q500_Q999;

public class Solution0643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            sum = Math.max(sum, sum + nums[k + i - 1] - nums[i]);
        }
        return sum / k;
    }
}
