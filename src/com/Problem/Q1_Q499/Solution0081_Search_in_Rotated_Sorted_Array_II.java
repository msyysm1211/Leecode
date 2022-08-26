package com.Problem.Q1_Q499;

public class Solution0081_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if (nums[0] <= target) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == target) {
                    return true;
                } else if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
                    return false;
                }
            }
        } else {
            for (int i = r; i >= 0; i--) {
                if (nums[i] == target) {
                    return true;
                } else if (i + 1 < n && nums[i] > nums[i + 1]) {
                    return false;
                }
            }
        }
        return false;
    }
}
