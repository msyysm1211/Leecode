package com.Problem.Q1_Q499;

public class Solution0198 {
    public int rob(int[] nums) {
        int res = 0;
        int n = nums.length;
        int opt[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            opt[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= i; j++) {
                opt[i] = Math.max(opt[i], opt[i - j] + nums[i]);
            }
        }
        for (int i : opt) {
            res = Math.max(i, res);
        }
        return res;
    }
}
