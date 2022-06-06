package com.Problem.Q1_Q499;

public class Solution0069 {
    public int mySqrt(int x) {
        int l = 0;
        int ans = 0;
        int r = x;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if ((long) m * m == x) {
                return m;
            } else if ((long) m * m > x) {
                r = m - 1;
            } else {
                ans = m;
                l = m + 1;
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution0069 a = new Solution0069();
        a.mySqrt(2147395599);
        a.mySqrt2(0);
    }
}
