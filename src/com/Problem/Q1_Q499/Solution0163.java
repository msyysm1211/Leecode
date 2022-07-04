package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int nums2[] = new int[nums.length + 2];
        nums2[0] = lower;
        nums[nums2.length - 1] = upper;
        for (int i = 0; i < nums.length; i++) {
            nums2[i + 1] = nums[i];
        }
        for (int i = 1; i < nums2.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 2) {
                res.add(String.valueOf(nums[i] - 1));
            } else {
                res.add(String.valueOf(nums[i - 1] + 1 + "->" + String.valueOf(nums[i] - 1)));
            }
        }
        return res;
    }
}
