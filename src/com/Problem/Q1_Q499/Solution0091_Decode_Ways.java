package com.Problem.Q1_Q499;

public class Solution0091_Decode_Ways {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c - '0' > 0) {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) - '0' != 0 && (s.charAt(i - 2) - '0') * 10 + (c - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution0091_Decode_Ways s = new Solution0091_Decode_Ways();
        System.out.println(s.numDecodings("06"));
    }

}
