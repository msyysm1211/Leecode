package com.Problem.Q1_Q499;

public class Solution0151 {
    public String reverseWords(String s) {
        int n = s.length();
        int l = n - 1, r = n - 1;
        StringBuffer res = new StringBuffer();
        while (l >= 0) {
            if (s.charAt(r) == ' ') {
                r--;
                l--;
            } else {
                while (l >= 0 && s.charAt(l) != ' ') {
                    l--;
                }
                res.append(s.substring(l + 1, r + 1));
                res.append(" ");
                r = l;
            }
        }
        String s1 = res.toString();
        return s1.substring(0, s1.length() - 1);
    }

    public static void main(String[] args) {
        Solution0151 s = new Solution0151();
        String t = s.reverseWords("the sky is blue");
        System.out.println(t);
    }
}
