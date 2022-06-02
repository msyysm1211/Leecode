package com.Problem.Q1_Q499;

import com.Problem.Q500_Q999.Solution0658;

public class Solution0300 {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] opt = new int[l];
        opt[0] = 1;
        int res = 0;
        for (int i = 1; i < l; i++) {
            opt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    opt[i] = Math.max(opt[j] + 1, opt[i]);
                }
            }
            res = Math.max(opt[i], res);
        }
        return res;
    }
    
    public static void main(String args[]) {
        Solution0300 a = new Solution0300();
        int b = a.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        // int b = a.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
        System.out.println(b);
    }
}
