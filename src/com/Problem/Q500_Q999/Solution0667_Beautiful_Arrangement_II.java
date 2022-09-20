package com.Problem.Q500_Q999;

public class Solution0667_Beautiful_Arrangement_II {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int flag = 0;
        for (int i = 1; i <= k - 1; i++) {
            res[flag] = i;
            flag++;
        }
        for (int i = flag, j = n; i <= n && j >= i; i++, j--) {
            res[flag] = i;
            flag++;
            if (i != j) {
                res[flag] = j;
                ++flag;
            }
        }
        return res;
    }
}
