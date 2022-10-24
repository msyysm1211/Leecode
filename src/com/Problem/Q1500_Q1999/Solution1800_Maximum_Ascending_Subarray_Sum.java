package com.Problem.Q1500_Q1999;

public class Solution1800_Maximum_Ascending_Subarray_Sum {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int res = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                max += nums[i];
            } else {
                max = nums[i];
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
