package com.Problem.Q500_Q999;

import java.util.Arrays;

public class Solution0724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftsum = 0;
        int rightsum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightsum = sum - leftsum - nums[i];
            if (rightsum == leftsum) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

    public static void main(String args[]) {
        Solution0724 s = new Solution0724();
        System.out.println(s.pivotIndex(new int[]{-1, -1, 0, 1, 1, 0}));
    }
}
