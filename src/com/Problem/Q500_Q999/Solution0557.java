package com.Problem.Q500_Q999;

public class Solution0557 {
    public String reverseWords(String s) {
        int r = 0;
        int n = s.length();
        StringBuffer res = new StringBuffer();
        while (r < n) {
            int start = r;
            while (r < n && s.charAt(r) != ' ') {
                r++;
            }
            for (int p = start; p < r; p++) {
                res.append(s.charAt(start + r - 1 - p));
            }
            while (r < n && s.charAt(r) == ' ') {
                r++;
                res.append(' ');
            }
        }
        return res.toString();
    }
}
