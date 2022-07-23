package com.Problem.Q1_Q499;

public class Solution0096 {

    public int numTrees(int n) {
        int opt[] = new int[n + 1];
        opt[0] = 1;
        opt[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                opt[i] += opt[j - 1] * opt[i - j];
            }
        }
        return opt[n];
    }

    public static void main(String[] args) {
        Solution0096 s = new Solution0096();
        System.out.println(s.numTrees(3));
    }
}
