package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0022 {
    List<String> res = new ArrayList<String>();
    StringBuffer path = new StringBuffer();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);
        return res;
    }

    void dfs(int n, int left, int right) {
        if (path.length() == n * 2) {
            res.add(new StringBuffer(path).toString());
            return;
        }
        if (left < n) {
            path.append("(");
            dfs(n, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < n) {
            path.append(")");
            dfs(n, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


    void dfs2(int n, int left, int right) {
        if (path.length() == n * 2) {
            res.add(new StringBuffer(path).toString());
            return;
        }
        for (int i = left; i < n; i++) {
            path.append("(");
            dfs(n, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        for (int i = right; i < left; i++) {
            path.append(")");
            dfs(n, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
