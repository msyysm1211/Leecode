package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution0016 a = new Solution0016();
        int t = a.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(t);
    }
}
