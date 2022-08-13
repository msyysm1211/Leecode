package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        int layer = (Math.min(m, n) + 1) / 2;
        for (int i = 0; i < layer; i++) {
            for (int j = i; j < n - i && res.size() < n * m; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i + 1; j < m - i - 1 && res.size() < n * m; j++) {
                res.add(matrix[j][n - 1 - i]);
            }
            for (int j = n - i - 1; j >= i && res.size() < n * m; j--) {
                res.add(matrix[m - i - 1][j]);
            }
            for (int j = m - i - 1 - 1; j >= i + 1 && res.size() < n * m; j--) {
                res.add(matrix[j][i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0054 s = new Solution0054();
        s.spiralOrder(new int[][]
                {{1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}}
        );
    }
}
