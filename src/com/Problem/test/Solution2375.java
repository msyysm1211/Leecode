package com.Problem.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2375 {
    String min = "999999999";
    boolean[] visit = new boolean[10];

    public String smallestNumber(String pattern) {
        StringBuffer buffer = new StringBuffer();
        Arrays.fill(visit, true);
        helper(buffer, pattern, pattern.length(), 0);
        return min;
    }

    void helper(StringBuffer sum, String pattern, int length, int start) {
        if (start == length + 1) {
            if (Integer.valueOf(min) > Integer.valueOf(sum.toString())) {
                min = sum.toString();
            }
            return;
        }
        for (int i = 1; i <= length + 1; i++) {
            int cur = i;
            char last;
            if (!sum.isEmpty()) {
                last = sum.charAt(sum.length() - 1);
                int pre = Integer.valueOf(last - '0');
                if ((visit[i] && pre > cur && pattern.charAt(start - 1) == 'D') || (visit[i] && pre < cur && pattern.charAt(start - 1) == 'I')) {
                    sum.append(cur);
                    visit[i] = false;
                    helper(sum, pattern, length, start + 1);
                    sum.deleteCharAt(sum.length() - 1);
                    visit[i] = true;
                } else {
                    continue;
                }
            } else {
                sum.append(i);
                visit[i] = false;
                helper(sum, pattern, length, start + 1);
                sum.deleteCharAt(sum.length() - 1);
                visit[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        Solution2375 s = new Solution2375();
        System.out.println(s.smallestNumber("DDD"));
    }

}
