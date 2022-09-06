package com.Problem.Q1_Q499;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution0150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                switch (s) {
                    case ("+"):
                        stack.push(n1 + n2);
                        break;
                    case ("-"):
                        stack.push(n1 - n2);
                        break;
                    case ("*"):
                        stack.push(n1 * n2);
                        break;
                    case ("/"):
                        stack.push(n1 / n2);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
