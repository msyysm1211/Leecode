package com.Problem.Q500_Q999;

import java.util.HashMap;
import java.util.Map;

public class Solution0873 {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        int n = arr.length;
        int[][] opt = new int[n][n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && 2 * arr[j] > arr[i]; j--) {
                int num = arr[i] - arr[j];
                int pre = map.getOrDefault(num, -1);
                if (pre >= 0) {
                    opt[j][i] = Math.max(opt[pre][j] + 1, 3);
                }
                max = Math.max(max, opt[j][i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0873 s = new Solution0873();
        System.out.println(s.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
