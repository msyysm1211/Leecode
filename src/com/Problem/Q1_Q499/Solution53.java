package com.Problem.Q1_Q499;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int opt[] = new int[nums.length];
        opt[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            opt[i] = Math.max(opt[i - 1] + nums[i], nums[i]);
            res = Math.max(res, opt[i]);
        }
        return res;
    }
}
