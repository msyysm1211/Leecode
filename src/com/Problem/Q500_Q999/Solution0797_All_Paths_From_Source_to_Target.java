package com.Problem.Q500_Q999;

import java.util.*;

public class Solution0797_All_Paths_From_Source_to_Target {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        path.add(0);
        dfs(graph, 0, n - 1);
        return res;
    }

    void dfs(int[][] graph, int start, int n) {
        if (start == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[start].length; i++) {
            path.add(graph[start][i]);
            dfs(graph, graph[start][i], n);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution0797_All_Paths_From_Source_to_Target s = new Solution0797_All_Paths_From_Source_to_Target();
        s.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
    }
}
