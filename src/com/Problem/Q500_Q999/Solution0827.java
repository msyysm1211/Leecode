package com.Problem.Q500_Q999;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution0827 {
    HashMap<Integer, Integer> group;
    HashMap<Integer, Integer> groupvalue;

    public int largestIsland(int[][] grid) {
        group = new HashMap<Integer, Integer>();
        groupvalue = new HashMap<Integer, Integer>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] area = new int[m][n];
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        int index = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int a = dfs(grid, i, j, index++);
                    groupvalue.put(index - 1, a);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(add(temp, i, j), max);
            }
        }
        return max;
    }

    int add(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[x][y] != 0) {
            return groupvalue.get(group.get(x * n + y));
        }
        Set<Integer> set = new HashSet<Integer>();
        if (x - 1 >= 0 && group.containsKey((x - 1) * n + y)) {
            set.add(group.get((x - 1) * n + y));
        }
        if (y - 1 >= 0 && group.containsKey(x * n + y - 1)) {
            set.add(group.get(x * n + y - 1));
        }
        if (x + 1 < n && group.containsKey((x + 1) * n + y)) {
            set.add(group.get((x + 1) * n + y));
        }
        if (y + 1 < m && group.containsKey(x * n + y + 1)) {
            set.add(group.get(x * n + y + 1));
        }
        int cnt = 1;
        for (Integer integer : set) {
            int value = groupvalue.get(integer);
            cnt += value;
        }
        return cnt;
    }
    
    int dfs(int[][] grid, int x, int y, int index) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 0;
        int cnt = 1;
        int n = grid[0].length;
        group.put(x * n + y, index);
        cnt += dfs(grid, x + 1, y, index);
        cnt += dfs(grid, x - 1, y, index);
        cnt += dfs(grid, x, y + 1, index);
        cnt += dfs(grid, x, y - 1, index);
        return cnt;
    }

    public static void main(String[] args) {
        Solution0827 s = new Solution0827();
        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        int r = s.largestIsland(grid);
        System.out.println(r);
    }
}
