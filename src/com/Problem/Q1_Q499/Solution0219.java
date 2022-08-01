package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.Set;

public class Solution0219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.size() > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0219 s = new Solution0219();
        boolean t = s.containsNearbyDuplicate(new int[]{2, 2}, 3);
        System.out.println(t);
    }
}
