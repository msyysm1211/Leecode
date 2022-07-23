package com.Problem.Q1_Q499;

import java.util.Map;

public class Solution0485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                l = i + 1;
            } else {
                max = Math.max(i - l + 1, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0485 s = new Solution0485();
        System.out.println(s.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
