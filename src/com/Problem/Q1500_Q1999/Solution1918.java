package com.Problem.Q1500_Q1999;

import java.util.Arrays;

public class Solution1918 {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int i : nums) {
            l = Math.min(l, i);
            r += i;
        }
        while (l < r) {
            int m = (r - l) / 2 + l;
            int count = countNumber(nums, m);
            if (count >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    int countNumber(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1918 s = new Solution1918();
        System.out.println(s.kthSmallestSubarraySum(new int[]{3, 3, 5, 5}, 7));
    }
}
