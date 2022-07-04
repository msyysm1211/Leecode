package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0046 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        DFS(nums, 0, visit);
        return res;
    }

    void DFS(int[] nums, int index, boolean[] visit) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (visit[i] == false) {
                path.add(nums[i]);
                visit[i] = true;
                DFS(nums, index + 1, visit);
                path.remove(path.size() - 1);
                visit[i] = false;
            }
        }
    }
}
