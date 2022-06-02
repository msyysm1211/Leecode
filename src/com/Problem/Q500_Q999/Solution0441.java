package com.Problem.Q500_Q999;

public class Solution0441 {
    public int arrangeCoins(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = (r - l + 1) / 2 + l;
            if ((long) m * (m + 1) / 2 <= (long) n) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
