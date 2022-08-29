package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0241_Different_Ways_to_Add_Parentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return dfs(expression, 0, n - 1);
    }

    public List<Integer> dfs(String expression, int start, int end) {
        List<Integer> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            List<Integer> l1 = dfs(expression, start, i - 1);
            List<Integer> l2 = dfs(expression, i + 1, end);
            for (Integer n1 : l1) {
                for (Integer n2 : l2) {
                    if (c == '+') {
                        res.add(n1 + n2);
                    } else if (c == '-') {
                        res.add(n1 - n2);
                    } else {
                        res.add(n1 * n2);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            String s = expression.substring(start, end + 1);
            int num = Integer.valueOf(s);
            res.add(num);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0241_Different_Ways_to_Add_Parentheses s = new Solution0241_Different_Ways_to_Add_Parentheses();
        s.diffWaysToCompute("2-1-2");
    }

}
