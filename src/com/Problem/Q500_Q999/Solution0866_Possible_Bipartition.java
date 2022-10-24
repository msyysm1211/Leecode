package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution0866_Possible_Bipartition {
    int[] colors;
    List<Integer>[] edge;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new int[n];
        edge = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int[] e : dislikes) {
            int node1 = e[0] - 1;
            int node2 = e[1] - 1;
            edge[node1].add(node2);
            edge[node2].add(node1);
        }
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int u, int color) {
        colors[u] = color;
        for (int i : edge[u]) {
            if (colors[i] == color) {
                return false;
            }
            if (colors[i] == 0 && !dfs(i, 3 - color)) {
                return false;
            }
        }
        return true;
    }

}
