package com.Problem.Q1_Q499;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Solution0093 {
    List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        dfs(0, s, "", 4);
        return res;
    }

    void dfs(int start, String s, String buffer, int count) {
        int n = s.length();
        StringBuffer path = new StringBuffer();
        path.append(buffer);
        if (count == 0) {
            if (start == n) {
                res.add(path.toString());
                return;
            }
        } else {
            for (int i = start; i < n; i++) {
                StringBuffer org = new StringBuffer(path);
                String temp = s.substring(start, i + 1);
                if (temp.charAt(0) == '0' && temp.length() > 1) break;
                int t = Integer.valueOf(temp);
                if (!helper(t)) {
                    break;
                } else {
                    path.append(String.valueOf(t));
                    if (count != 1) {
                        path.append(".");
                    }
                    dfs(i + 1, s, path.toString(), count - 1);
                    path = org;
                }
            }
        }
    }

    boolean helper(int n) {
        return n >= 0 && n <= 255;
    }

    public static void main(String[] args) {
        Solution0093 s = new Solution0093();
        s.restoreIpAddresses("101023");
    }
}
