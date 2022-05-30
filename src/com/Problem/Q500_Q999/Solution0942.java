package com.Problem.Q500_Q999;

public class Solution0942 {
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
        Solution0942 a = new Solution0942();
        int[] t = a.diStringMatch("IDID");
        int w;
    }
}
