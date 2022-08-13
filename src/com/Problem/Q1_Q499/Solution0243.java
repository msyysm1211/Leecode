package com.Problem.Q1_Q499;

import java.util.Map;

public class Solution0243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int l = -1, r = -1;
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                l = i;
            } else if (wordsDict[i].equals(word2)) {
                r = i;
            }
            if (l >= 0 && r >= 0) {
                ans = Math.min(Math.abs(r - l), ans);
            }
        }
        return ans;
    }
}
