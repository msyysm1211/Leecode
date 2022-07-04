package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.Map;

public class Solution409 {
    public int longestPalindrome(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int num = map.get(s.charAt(i));
                map.put(s.charAt(i), num + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int sum = entry.getValue();
            if (sum >= 2) {
                res += (sum / 2) * 2;
            }
        }

        return res < s.length() ? res + 1 : res;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        for (int i : count) {
            ans += i / 2 * 2;
            if (i % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution409 s = new Solution409();
        s.longestPalindrome("abccccdd");
    }
}
