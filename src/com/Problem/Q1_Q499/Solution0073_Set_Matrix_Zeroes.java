package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0073_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] col = new boolean[m];
        boolean[] row = new boolean[n];
        Arrays.fill(col, false);
        Arrays.fill(row, false);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (col[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
