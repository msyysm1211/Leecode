package com.Problem.Q1_Q499;

public class Solution0374 {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while (l < r) {
            int middle = (r - l) / 2 + l;
            if (guess(middle) == 0) {
                return middle;
            } else if (guess(middle) == -1) {
                r = middle - 1;
            } else if (guess(middle) == 1) {
                l = middle + 1;
            }
        }
        return l;
    }

    int guess(int num) {
        return 1;
    }
}
