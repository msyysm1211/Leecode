package com.Problem.Q500_Q999;

import java.util.Arrays;

public class Solution0983 {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int max = days[n - 1];
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        int[] tickets = {1, 7, 30};
        int index = 0;
        for (int i = 1; i <= max; i++) {
            if (i == days[index]) {
                int way1 = i - 1 >= 0 ? i - 1 : 0;
                int way2 = i - 7 >= 0 ? i - 7 : 0;
                int way3 = i - 30 >= 0 ? i - 30 : 0;
                dp[i] = Math.min(Math.min(dp[way1] + costs[0], dp[way2] + costs[1]), dp[way3] + costs[2]);
                index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[max];
    }

    public static void main(String[] args) {
        Solution0983 s = new Solution0983();
        int t = s.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
        System.out.println(t);
    }
}
