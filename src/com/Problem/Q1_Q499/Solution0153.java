package com.Problem.Q1_Q499;

import com.Problem.Q500_Q999.Solution0704;

public class Solution0153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public static void main(String args[]) {
        Solution0153 a = new Solution0153();
        int t = a.findMin(new int[]{2, 1});
        System.out.println(t);
    }
}
