package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0216 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n, 0);
        return res;
    }

    void dfs(int depth, int k, int n, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
        } else {
            for (int i = depth; i <= 9; i++) {
                sum += i;
                path.add(i);
                dfs(i + 1, k, n, sum);
                path.remove(path.size() - 1);
                sum -= i;
            }
        }
    }

    public static void main(String[] args) {
        Solution0216 s = new Solution0216();
        s.combinationSum3(3, 7);
    }
}
