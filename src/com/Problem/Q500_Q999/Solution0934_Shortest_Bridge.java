package com.Problem.Q500_Q999;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution0934_Shortest_Bridge {
    final int[][] offset = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, grid, deque);
                int step = 0;
                while (!deque.isEmpty()) {
                    int size = deque.size();
                    for (int k = 0; k < size; k++) {
                        int[] arr = deque.pollFirst();
                        int x = arr[0], y = arr[1];
                        for (int[] off : offset) {
                            int nx = x + off[0];
                            int ny = y + off[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (grid[nx][ny] == 0) {
                                    deque.addLast(new int[]{nx, ny});
                                    grid[nx][ny] = -1;
                                } else if (grid[nx][ny] == 1) {
                                    return step;
                                }
                            }
                        }
                    }
                    step++;
                }
            }
        }
        return 0;
    }

    void dfs(int i, int j, int[][] grid, Deque deque) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        deque.addLast(new int[]{i, j});
        for (int[] ints : offset) {
            dfs(i + ints[0], j + ints[1], grid, deque);
        }
    }
}
