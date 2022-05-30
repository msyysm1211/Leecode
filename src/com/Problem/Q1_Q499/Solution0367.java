package com.Problem.Q1_Q499;

public class Solution0367 {
    public boolean isPerfectSquare(int num) {
        int n = (int) Math.sqrt(num);
        return n * n == num;
    }

    public boolean isPerfectSquare2(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            long n = m * m;
            if (n == num) {
                return true;
            } else if (n > num) {
                r = m - 1;
            } else if (n < num) {
                l = m + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare3(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
