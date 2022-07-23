package com.Problem.Q1000_Q1499;

import com.Problem.Q1_Q499.Solution0486;

public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int max = 0;
        int count = 0;
        while (r < n) {
            if (nums[r] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }

            max = Math.max(r - l + 1, max);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1004 s = new Solution1004();
        System.out.println(s.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
