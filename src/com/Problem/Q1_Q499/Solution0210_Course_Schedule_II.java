package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        List<Integer> path = new ArrayList<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            edges.put(i, new ArrayList<>());
            degree.put(i, 0);
        }
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int courseid = prerequisites[i][0];
            int requirecourse = prerequisites[i][1];
            degree.put(courseid, degree.getOrDefault(courseid, 0) + 1);
            edges.get(requirecourse).add(courseid);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> adj = edges.get(node);
            path.add(node);
            for (Integer pre : adj) {
                int num = degree.get(pre);
                degree.put(pre, num - 1);
                if (num - 1 == 0) {
                    queue.add(pre);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
            if (entry.getValue() > 0) {
                return new int[0];
            }
        }
        int[] res = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            res[i] = path.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0210_Course_Schedule_II s = new Solution0210_Course_Schedule_II();
        System.out.println(s.findOrder(2, new int[][]{}));
    }

}
