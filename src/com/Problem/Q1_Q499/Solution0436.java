package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] start = new int[n][2];
        for (int i = 0; i < n; i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }
        Arrays.sort(start, (o1, o2) -> o1[0] - o2[0]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int l = 0, r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (start[m][0] < end) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (start[l][0] >= end) {
                arr[i] = start[l][1];
            } else {
                arr[i] = -1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution0436 s = new Solution0436();
        s.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
    }
}
