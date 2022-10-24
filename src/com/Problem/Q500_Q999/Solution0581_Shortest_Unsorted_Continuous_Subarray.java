package com.Problem.Q500_Q999;

public class Solution0581_Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = -1, r = 0;
        int min = nums[0];
        int max = nums[n - 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                l = i;
            } else {
                min = nums[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                r = i;
            } else {
                max = nums[i];
            }
        }
        return l - r + 1;
    }

    public static void main(String[] args) {
        Solution0581_Shortest_Unsorted_Continuous_Subarray s = new Solution0581_Shortest_Unsorted_Continuous_Subarray();
        System.out.println(s.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }

}
