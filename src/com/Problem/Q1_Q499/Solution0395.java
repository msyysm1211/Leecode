package com.Problem.Q1_Q499;

import java.util.HashMap;

public class Solution0395 {
    public int longestSubstring(String s, int k) {
        int max = 0;
        int l = 0, r = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int vaildnum = 0;
            l = 0;
            r = 0;
            while (r < n) {
                char rightchar = s.charAt(r);
                map.put(rightchar, map.getOrDefault(rightchar, 0) + 1);
                if (map.get(rightchar) == k) {
                    vaildnum++;
                }
                while (map.size() > t) {
                    char leftchar = s.charAt(l);
                    if (map.getOrDefault(leftchar, 0) == k) {
                        vaildnum--;
                    }
                    map.put(leftchar, map.getOrDefault(leftchar, 0) - 1);
                    if (map.get(leftchar) == 0) {
                        map.remove(leftchar);
                    }
                    l++;
                }
                if (map.size() == t && vaildnum == map.size()) {
                    max = Math.max(max, r - l + 1);
                }
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0395 s = new Solution0395();
        System.out.println(s.longestSubstring("ababbc", 2));
    }
}
