package com.Problem.Q1_Q499;

public class Solution0344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            reverse(s, l, r);
            l++;
            r--;
        }
    }

    void reverse(char[] s, int l, int r) {
        char temp;
        temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
