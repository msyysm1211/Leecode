package com.Problem.Q500_Q999;

public class Solution0746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution0746_Min_Cost_Climbing_Stairs s = new Solution0746_Min_Cost_Climbing_Stairs();
        System.out.println(s.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

}
