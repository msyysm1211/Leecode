package com.Problem.Q500_Q999;

import java.util.Arrays;
import java.util.OptionalInt;

public class Solution0740 {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = cnt[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * cnt[i]);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        Solution0740 s = new Solution0740();
        System.out.println(s.deleteAndEarn(new int[]{3, 4, 2}));
    }
}
