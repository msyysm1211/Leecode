package com.Problem.Q1_Q499;

public class Solution0048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                swap(matrix, i, j, n - j - 1, i);
                swap(matrix, n - j - 1, i, n - i - 1, n - j - 1);
                swap(matrix, n - i - 1, n - j - 1, j, n - i - 1);
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
