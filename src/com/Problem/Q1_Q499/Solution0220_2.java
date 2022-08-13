package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution0220_2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        if (k == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            Long temp = set.ceiling((long) nums[i] - t);
            if (temp != null && temp <= (long) nums[i] + t) {
                return true;
            }
            if (set.size() >= k) {
                set.remove((long) nums[i - k]);
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0220_2 s = new Solution0220_2();
        boolean t = s.containsNearbyAlmostDuplicate(new int[]{1, 2}, 0, 1);
        System.out.println(t);
    }
}
