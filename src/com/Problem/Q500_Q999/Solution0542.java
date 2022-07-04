package com.Problem.Q500_Q999;

public class Solution0542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int opt[][] = new int[m][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    opt[i][j] = 0;
                } else {
                    opt[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {//左和上
            for (int j = 0; j < mat[0].length; j++) {
                if (i - 1 >= 0) {
                    opt[i][j] = Math.min(opt[i][j], opt[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    opt[i][j] = Math.min(opt[i][j], opt[i][j - 1] + 1);
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {//左和下
            for (int j = n - 1; j >= 0; j--) {
                if (i - 1 >= 0) {
                    opt[i][j] = Math.min(opt[i][j], opt[i - 1][j] + 1);
                }
                if (j + 1 < n) {
                    opt[i][j] = Math.min(opt[i][j], opt[i][j + 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {//右上
            for (int j = 0; j < mat[0].length; j++) {
                if (i + 1 < m) {
                    opt[i][j] = Math.min(opt[i][j], opt[i + 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    opt[i][j] = Math.min(opt[i][j], opt[i][j - 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {//右下
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    opt[i][j] = Math.min(opt[i][j], opt[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    opt[i][j] = Math.min(opt[i][j], opt[i][j + 1] + 1);
                }
            }
        }
        return opt;
    }
}
