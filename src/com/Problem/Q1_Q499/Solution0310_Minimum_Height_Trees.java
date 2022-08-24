package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0310_Minimum_Height_Trees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int edgenum = edges.length;
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            degree.put(i, 0);
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edgenum; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            adj.get(start).add(end);
            adj.get(end).add(start);
            degree.put(start, degree.get(start) + 1);
            degree.put(end, degree.get(end) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 1) {
                queue.add(entry.getKey());
            }
        }
        int count = n;
        while (count > 2) {
            count -= queue.size();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int start = queue.poll();
                List<Integer> adjacent = adj.get(start);
                for (Integer end : adjacent) {
                    int enddegree = degree.get(end);
                    int startdegree = degree.get(start);
                    degree.put(end, enddegree - 1);
                    degree.put(start, startdegree - 1);
                    if (enddegree - 1 == 1) {
                        queue.add(end);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0310_Minimum_Height_Trees s = new Solution0310_Minimum_Height_Trees();
        System.out.println(s.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }

}
