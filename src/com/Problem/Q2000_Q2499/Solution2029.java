package com.Problem.Q2000_Q2499;

public class Solution2029 {
    public boolean stoneGameIX(int[] stones) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i : stones) {
            if (i % 3 == 0) {
                count0++;
            }
            if (i % 3 == 1) {
                count1++;
            }
            if (i % 3 == 2) {
                count2++;
            }
        }
        if (count0 % 2 == 0) {
            return count1 >= 1 && count2 >= 1;
        }
        return count1 - count2 > 2 || count2 - count1 > 2;
    }
}
