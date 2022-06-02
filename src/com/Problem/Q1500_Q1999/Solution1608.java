package com.Problem.Q1500_Q1999;

import com.Problem.Q1_Q499.Solution0167;

import java.util.Arrays;

public class Solution1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1];
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (check(nums, m) == m) {
                return m;
            } else if (check(nums, m) > m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    int check(int[] nums, int target) {
        int count = 0;
        for (int i : nums) {
            if (i >= target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Solution1608 a = new Solution1608();
        int t = a.specialArray(new int[]{4, 4, 4, 4});
        System.out.println(t);
    }
}
