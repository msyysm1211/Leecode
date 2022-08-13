package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution0242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            char c2 = t.charAt(i);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }
        return map1.equals(map2);
    }
}
