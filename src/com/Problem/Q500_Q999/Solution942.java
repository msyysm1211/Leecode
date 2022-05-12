package com.Problem.Q500_Q999;

import com.Problem.Q500_Q999.Solution942;

public class Solution942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;
        int perm[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            perm[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        perm[n] = low;
        return perm;
    }

    public static void main(String args[]) {
        Solution942 a = new Solution942();
        int[] t = a.diStringMatch("IDID");
        int w;
    }
}
