package com.Problem.Q1_Q499;

public class Solution0097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (l != n + m) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[i][j];
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) || dp[i][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution0097 s = new Solution0097();
        s.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }
}
