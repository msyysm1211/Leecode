package com.Problem.Q1_Q499;

import java.util.Arrays;
import java.util.Comparator;

public class Solution0452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        int r = points[0][1];
        int count = 1;
        for (int[] point : points) {
            if (point[0] > r) {
                count++;
                r = point[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution0452 s = new Solution0452();
        stringToArray t = new stringToArray();
        int x = s.findMinArrowShots(t.stringToInt2dArray("[[-2147483646,-2147483645],[2147483646,2147483647]]"));
        System.out.println(x);
    }
}
