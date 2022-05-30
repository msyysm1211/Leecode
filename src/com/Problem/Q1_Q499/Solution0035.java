package com.Problem.Q1_Q499;

public class Solution0035 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int middle = (r - l) / 2 + l;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else if (nums[middle] > target) {
                r = middle - 1;
            }
        }
        return nums[l] < target ? l + 1 : l;
    }
}
