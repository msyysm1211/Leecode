package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0473 {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    public boolean makesquare2(int[] matchsticks) {
        int edge = Arrays.stream(matchsticks).sum() / 4;
        int n = matchsticks.length;
        int[] edges = new int[4];
        Arrays.sort(matchsticks);
        int i = 0, j = n - 1;
        while (i < j) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
            i++;
            j--;
        }
        return dfs(matchsticks, 0, edge, edges);
    }

    boolean dfs(int[] matchsticks, int start, int edge, int edges[]) {
        if (start == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            edges[i] += matchsticks[start];
            if (edges[i] <= edge && dfs(matchsticks, start + 1, edge, edges)) {
                return true;
            }
            edges[i] -= matchsticks[start];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0473 s = new Solution0473();
        boolean t = s.makesquare(new int[]{1, 1, 2, 2, 2});
        System.out.println(t);
    }
}
