package com.Problem.Q1_Q499;

public class Solution0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                res = Math.min(end - start + 1, res);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
