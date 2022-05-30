package com.Problem.Q500_Q999;

public class Solution0744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (letters[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return letters[l];
    }

}
