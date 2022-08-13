package com.Problem.Q1_Q499;

public class Solution0059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int layer = (n + 1) / 2;
        int cur = 1;
        int size = n * n;
        for (int l = 0; l < layer; l++) {
            for (int i = l; i < n - l && cur <= size; i++) {
                res[l][i] = cur;
                cur++;
            }
            for (int i = l + 1; i < n - l - 1 && cur <= size; i++) {
                res[i][n - l - 1] = cur;
                cur++;
            }
            for (int i = n - l - 1; i >= l && cur <= size; i--) {
                res[n - l - 1][i] = cur;
                cur++;
            }
            for (int i = n - 1 - l - 1; i >= l + 1 && cur <= size; i--) {
                res[i][l] = cur;
                cur++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0059 s = new Solution0059();
        s.generateMatrix(3);
    }
}
