package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0131_2 {
    boolean[][] arr;
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                arr[i][j] = arr[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        dfs(s, 0);
        return res;
    }

    void dfs(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (arr[index][i]) {
                path.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution0131_2 s = new Solution0131_2();
        s.partition("abb");
    }
}
