package com.Problem.Q1500_Q1999;

import java.util.HashMap;
import java.util.Map;

public class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int l = 0, r = 0;
        int n = nums.length;
        int max = 0;
        int sum = 0;
        while (r < n) {
            if (!map.containsKey(nums[r])) {
                map.put(nums[r], 1);
                sum += nums[r];
            } else {
                while (map.get(nums[r]) != null) {
                    sum -= nums[l];
                    map.remove(nums[l]);
                    l++;
                }
                map.put(nums[r], 1);
                sum += nums[r];
            }
            r++;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1695 s = new Solution1695();
        System.out.println(s.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }
}
