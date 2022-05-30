package com.Problem.Q1_Q499;

public class Solution0278 {
    public int firstBadVersion(int n) {
        int res = -1;
        int l = 1;
        int r = n;
        while (l < r) {
            int middle = (r - l) / 2 + l;
            if (isBadVersion(middle) == true) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return res;
    }

    boolean isBadVersion(int i) {
        return false;
    }
}
