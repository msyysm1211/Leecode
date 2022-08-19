package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.Set;

public class Solution0389 {
    public char findTheDifference(String s, String t) {
        int[] arr1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr1[t.charAt(i) - 'a']--;
            if (arr1[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }
}
