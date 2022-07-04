package com.Problem.Q500_Q999;

import com.Problem.Q1000_Q1499.Solution1385;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution0994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(n * i + j);
                    map.put(n * i + j, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int point = queue.poll();
            int x = point / n;
            int y = point % n;
            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                grid[x - 1][y] = 2;
                int temp = n * (x - 1) + y;
                queue.add(temp);
                map.put(temp, map.get(point) + 1);
                ans = map.get(temp);
            }
            if (y + 1 < n && grid[x][y + 1] == 1) {
                grid[x][y + 1] = 2;
                int temp = n * x + y + 1;
                queue.add(temp);
                map.put(temp, map.get(point) + 1);
                ans = map.get(temp);
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                grid[x][y - 1] = 2;
                int temp = n * x + y - 1;
                queue.add(temp);
                map.put(temp, map.get(point) + 1);
                ans = map.get(temp);
            }
            if (x + 1 < m && grid[x + 1][y] == 1) {
                grid[x + 1][y] = 2;
                int temp = n * (x + 1) + y;
                queue.add(temp);
                map.put(temp, map.get(point) + 1);
                ans = map.get(temp);
            }
        }
        for (int[] i : grid) {
            for (int j : i) {
                if (j == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution0994 a = new Solution0994();
        int t = a.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(t);
    }
}
