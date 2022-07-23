package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.List;

public class Solution0986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<int[]>();
        int cur1 = 0, cur2 = 0;
        int m = firstList.length, n = secondList.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            cur1 = Math.max(firstList[i][0], secondList[j][0]);
            cur2 = Math.min(firstList[i][1], secondList[j][1]);
            if (cur2 >= cur1) {
                res.add(new int[]{cur1, cur2});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
