package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0131 {
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();

    public List<List<String>> partition(String s) {
        dfs(0, s);
        for (int i = 0; i < res.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < res.get(i).size(); j++) {
                flag = helper(res.get(i).get(j));
                if (!flag) break;
            }
            if (!flag) {
                res.remove(i);
                i--;
            }
        }
        return res;
    }

    void dfs(int start, String s) {
        int n = s.length();
        if (n == start) {
            List<String> ans = new ArrayList<>(path);
            res.add(ans);
            return;
        }
        for (int i = start; i < n; i++) {
            path.add(s.substring(start, i + 1));
            dfs(i + 1, s);
            path.remove(path.size() - 1);
        }
    }

    boolean helper(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0131 s = new Solution0131();
        s.partition("cdd");
    }
}
