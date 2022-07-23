package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0438 {
    public List<Integer> findAnagrams(String s, String p) {
        int size = p.length();
        int l = 0, r = size - 1;
        int n = s.length();
        List<Integer> res = new ArrayList<Integer>();
        int scount[] = new int[26];
        int pcount[] = new int[26];
        if (n < size) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(scount, pcount)) {
            res.add(0);
        }
        for (int i = 0; i < n - size; i++) {
            scount[s.charAt(r + i + 1) - 'a']++;
            scount[s.charAt(l + i) - 'a']--;
            if (Arrays.equals(scount, pcount)) {
                res.add(l + i + 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution0438 s = new Solution0438();
        System.out.println(s.findAnagrams("abab", "ab"));
    }
}
