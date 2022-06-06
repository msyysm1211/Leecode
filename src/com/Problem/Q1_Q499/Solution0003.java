package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.Set;

public class Solution0003 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 1;
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                left++;
                set.remove(s.charAt(left));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
