package com.Problem.Q500_Q999;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0961 {
    public int repeatedNTimes(int[] nums) {
        int res;
        Set<Integer> set = new HashSet<>();
        for (int t : nums) {
            if (!set.contains(t)) {
                set.add(t);
            } else {
                return t;
            }
        }
        return 0;
    }
}
