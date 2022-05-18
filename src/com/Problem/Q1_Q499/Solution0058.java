package com.Problem.Q1_Q499;

public class Solution0058 {
    public int lengthOfLastWord(String s) {
        String res;
        int count = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                n--;
            } else {
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        Solution0058 a = new Solution0058();
        a.lengthOfLastWord("hello world ");
    }
}
