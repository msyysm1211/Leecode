package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> dic = new HashSet<String>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && dic.contains(s.substring(j, i));
                if (dp[i] == true) {
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution0139 s = new Solution0139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        s.wordBreak("leetcode", list);
    }
}
