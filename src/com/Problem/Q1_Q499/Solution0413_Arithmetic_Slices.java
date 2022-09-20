package com.Problem.Q1_Q499;

public class Solution0413_Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        if (n < 3) {
            return 0;
        }
        int temp = 1;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count += temp;
                temp++;
            } else {
                temp = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution0413_Arithmetic_Slices s = new Solution0413_Arithmetic_Slices();
        System.out.println(s.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

}
