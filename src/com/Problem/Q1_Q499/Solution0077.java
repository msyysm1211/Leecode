package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0077 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        DFS(0, n, k);
        return res;
    }

    void DFS(int cur, int n, int k) {
        if (temp.size() + n - cur + 1 < k) {
            return;
        }
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        DFS(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        DFS(cur + 1, n, k);
    }

    public static void main(String args[]) {
        Solution0077 s = new Solution0077();
        s.combine(4, 2);
    }
}
