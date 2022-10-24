package com.Problem.Q1500_Q1999;

public class Solution1768_Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuffer buf = new StringBuffer();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (i < n1) {
                buf.append(word1.charAt(i));
                i++;
            }
            if (j < n2) {
                buf.append(word2.charAt(j));
                j++;
            }
        }
        while (i < n1) {
            buf.append(word1.charAt(i));
            i++;

        }
        while (j < n2) {
            buf.append(word2.charAt(j));
            j++;
        }
        return buf.toString();
    }
}
