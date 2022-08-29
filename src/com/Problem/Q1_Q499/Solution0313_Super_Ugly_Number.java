package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0313_Super_Ugly_Number {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;
        long[] dp = new long[n + 1];
        long[] arrs = new long[length];
        int[] pointers = new int[length];
        Arrays.fill(arrs, 1);
        for (int i = 1; i <= n; i++) {
            long min = Arrays.stream(arrs).min().getAsLong();
            dp[i] = min;
            for (int j = 0; j < length; j++) {
                if (min == arrs[j]) {
                    pointers[j]++;
                    arrs[j] = dp[pointers[j]] * primes[j];

                }
            }
        }
        return (int) dp[n];
    }
}
