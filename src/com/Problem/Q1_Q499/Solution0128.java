package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.HashSet;

public class Solution0128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            int count = 0;
            if (!set.contains(num - 1)) {
                int cur = num;
                while (set.contains(cur)) {
                    count++;
                    cur++;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
