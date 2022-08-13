package com.Problem.Q1_Q499;

public class Solution0345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < n && !help(arr[l])) {
                l++;
            }
            while (r >= 0 && !help(arr[r])) {
                r--;
            }
            if (l < r)
                swap(arr, l, r);
            l++;
            r--;
        }
        return new String(arr);
    }

    boolean help(char c) {
        String s = "aeiouAEIOU";
        return s.indexOf(c) >= 0;
    }

    void swap(char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }

    public static void main(String[] args) {
        Solution0345 s = new Solution0345();
        System.out.println(s.reverseVowels("hello"));
    }
}
