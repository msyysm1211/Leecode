package com.Problem.test;

public class Solution2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[edges[i]] += i;
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2374 s = new Solution2374();
        System.out.println(s.edgeScore(new int[]{2, 0, 0, 2}));
    }

}
