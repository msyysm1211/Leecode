package com.Problem.Q1_Q499;

public class Solution0392 {
    public boolean isSubsequence(String s, String t) {
        int slow = 0, fast = 0;
        if (s.length() == 0) {
            return true;
        }
        while (fast < t.length()) {
            int c1 = s.charAt(slow), c2 = t.charAt(fast);
            if (c1 == c2) {
                slow++;
                fast++;
            } else {
                fast++;
            }
            if (slow == s.length()) {
                return true;
            }
        }
        return slow == s.length();
    }
}
