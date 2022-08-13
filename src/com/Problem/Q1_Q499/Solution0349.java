package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (Integer integer : nums2) {
            set2.add(integer);
        }
        for (Integer integer : set2) {
            if (set.contains(integer)) {
                res.add(integer);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0349 s = new Solution0349();
        s.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }
}
