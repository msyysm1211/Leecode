package com.Problem.Q1_Q499;

public class Solution0304_Range_Sum_Query_2D_Immutable {
    int[][] matrix2D;
    int[][] arr;

    public Solution0304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        matrix2D = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        arr = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j + 1] = arr[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += arr[i][col2 + 1] - arr[i][col1];
        }
        return res;
    }

    public static void main(String[] args) {
        stringToArray t = new stringToArray();

        int[][] matrix = t.stringToInt2dArray("[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]");
        Solution0304_Range_Sum_Query_2D_Immutable s = new Solution0304_Range_Sum_Query_2D_Immutable(matrix);
        System.out.println(s.sumRegion(2, 1, 4, 3));
    }

}
