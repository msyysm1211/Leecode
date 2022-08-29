package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0204_Count_Primes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isprime(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isprime(int num) {
        int x = (int) Math.sqrt(num);
        for (int i = 2; i <= x; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes2(int n) {
        boolean[] nums = new boolean[n];
        Arrays.fill(nums, true);
        for (int i = 2; i * i < n; i++) {
            if (isprime(i)) {
                for (int j = i * i; j < n; j += i) {
                    nums[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution0204_Count_Primes s = new Solution0204_Count_Primes();
        s.countPrimes2(10);
    }
}
