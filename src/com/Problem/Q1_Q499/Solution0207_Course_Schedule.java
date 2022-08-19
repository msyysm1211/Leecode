package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0207_Course_Schedule {
    List<List<Integer>> path = new ArrayList<>();
    int[] visit;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            path.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            path.get(prerequisite[1]).add(prerequisite[0]);//path
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    boolean dfs(int start) {
        if (visit[start] == 1) return false;
        if (visit[start] == -1) return true;//已访问
        visit[start] = 1;
        for (int end : path.get(start)) {
            if (!dfs(end)) {
                return false;
            }
            ;
        }
        visit[start] = -1;
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();//保存节点度
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);
        }
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            if (adjacent.containsKey(end)) {
                adjacent.get(end).add(start);
            } else {
                List<Integer> adj = new ArrayList<>();
                adj.add(start);
                adjacent.put(end, adj);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!adjacent.containsKey(node)) {
                continue;
            }
            List<Integer> afteradj = adjacent.get(node);
            for (Integer end : afteradj) {
                map.put(end, map.get(end) - 1);//度减少一
                if (map.get(end) == 0) {
                    queue.add(end);
                }
            }
        }
        for (Integer value : map.values()) {
            if (value != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0207_Course_Schedule s = new Solution0207_Course_Schedule();
        System.out.println(s.canFinish2(2, new int[][]{{1, 0},}));
    }

}
