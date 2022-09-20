package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0435_Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count - 1;
    }

    public static void main(String[] args) {
        Solution0435_Non_overlapping_Intervals s = new Solution0435_Non_overlapping_Intervals();
        s.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
    }
}
