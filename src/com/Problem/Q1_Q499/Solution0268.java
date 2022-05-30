package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.Set;

public class Solution0268 {
    public int missingNumber(int[] nums) {
        int res = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return res;
    }
}
