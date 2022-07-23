package com.Problem.Q1_Q499;

import java.util.HashMap;

public class Solution0159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l = 0, r = 0;
        int n = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (r < n) {
            char c = s.charAt(r);
            if (map.size() <= 2) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    int count = map.get(c);
                    map.put(c, count + 1);
                }
                r++;
            } else {
                while (map.size() > 2) {
                    char c2 = s.charAt(l);
                    if (map.get(c2) == 1) {
                        map.remove(c2);
                    } else {
                        int num = map.get(c2);
                        map.put(c2, num - 1);
                    }
                    l++;
                }
            }
            if (map.size() < 2) {
                max = Math.max(max, r - l);
            }
        }
        return max;
    }
}
