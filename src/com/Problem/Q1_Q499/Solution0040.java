package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0040 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        DFS(candidates, 0, target);
        return res;
    }

    void DFS(int[] candidates, int cur, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > cur && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            DFS(candidates, i + 1, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution0040 solution = new Solution0040();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }
}
