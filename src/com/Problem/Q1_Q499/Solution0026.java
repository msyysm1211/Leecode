package com.Problem.Q1_Q499;

public class Solution0026 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[slow] != nums[i]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow + 1;
    }
}
