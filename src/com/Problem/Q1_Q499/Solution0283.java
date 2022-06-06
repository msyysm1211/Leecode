package com.Problem.Q1_Q499;

public class Solution0283 {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    void swap(int[] nums, int l, int r) {
        int temp;
        temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
