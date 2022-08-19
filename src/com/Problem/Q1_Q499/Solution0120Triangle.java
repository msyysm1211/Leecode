package com.Problem.Q1_Q499;

import java.util.Arrays;
import java.util.List;

public class Solution0120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j >= i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + triangle.get(i).get(j), dp[i - 1][j - 1] + triangle.get(i).get(j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int ints : dp[n]) {
            min = Math.min(min, ints);
        }
        return min;
    }
}
