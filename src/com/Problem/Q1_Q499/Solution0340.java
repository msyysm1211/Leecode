package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        while (r < n) {
            char c2 = s.charAt(r);
            if (map.size() <= k) {
                if (!map.containsKey(c2)) {
                    map.put(c2, 1);
                } else {
                    map.put(c2, map.get(c2) + 1);
                }
                r++;
            } else {
                while (map.size() > k) {
                    char c1 = s.charAt(l);
                    if (map.get(c1) == 1) {
                        map.remove(c1);
                    } else {
                        int num = map.get(c1);
                        map.put(c1, num - 1);
                    }
                    l++;
                }
            }
            if (map.size() <= k)
                max = Math.max(r - l, max);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution0340 s = new Solution0340();
        System.out.println(s.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
