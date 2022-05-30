package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.Set;

class Solution0217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
