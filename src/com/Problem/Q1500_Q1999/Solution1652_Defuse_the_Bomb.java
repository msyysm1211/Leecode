package com.Problem.Q1500_Q1999;

import java.util.Arrays;

public class Solution1652_Defuse_the_Bomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];
        int sum = 0;
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                sum = sum + code[i];
            }
            for (int i = 0; i < n; i++) {
                sum = sum - code[i] + code[(i + k) % n];
                arr[i] = sum;
            }
        }
        if (k < 0) {
            // sum += code[0];
            for (int i = 0; i < -k; i++) {
                sum = sum + code[n - 1 - i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = sum;
                sum = sum + code[i] - code[(n + i + k) % n];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution1652_Defuse_the_Bomb s = new Solution1652_Defuse_the_Bomb();
        System.out.println(s.decrypt(new int[]{2, 4, 9, 3}, -2));
    }

}
