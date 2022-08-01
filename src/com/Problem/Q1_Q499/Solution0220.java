package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            if (set.size() > k) {
                set.remove((long) nums[i - k - 1]);
            }
            Long temp = set.ceiling((long) nums[i] - t);
            if (temp != null && temp <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0220 s = new Solution0220();
        s.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }
}
