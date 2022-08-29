package com.Problem.Q1_Q499;

public class Solution0318_Maximum_Product_of_Word_Lengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                arrs[i] |= 1 << (s.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((arrs[i] & arrs[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}
