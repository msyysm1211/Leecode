package com.Problem.Q1_Q499;

public class Solution0029 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend > Integer.MIN_VALUE ? -dividend : Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        int tag = -1;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            tag = 1;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        return tag == -1 ? -helper(a, b) : helper(a, b);
    }

    int helper(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int temp = divisor;
        int cur = 1;
        while (divisor + divisor >= dividend && divisor + dividend < 0) {
            cur += cur;
            divisor += divisor;
        }
        return cur + helper(dividend - divisor, temp);
    }

    public static void main(String[] args) {
        Solution0029 s = new Solution0029();
        System.out.println(s.divide(10,
                3));
    }
}
