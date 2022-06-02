package com.Problem.Q500_Q999;

public class Solution0633 {
    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            if (l * l + r * r == c) {
                return true;
            } else if (l * l + r * r > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }
}
