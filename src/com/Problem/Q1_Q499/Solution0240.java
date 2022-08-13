package com.Problem.Q1_Q499;

public class Solution0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = m;
        while (x >= 0 && y < n) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
