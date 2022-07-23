package com.Problem.Q1_Q499;

public class Solution0080 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int n = nums.length;
        int count = 0;
        for (int fast = 0; fast < n; fast++) {
            if (slow < 2 || nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution0080 s = new Solution0080();
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
    }
}
