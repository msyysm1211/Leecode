package com.Problem.Q500_Q999;

import scala.Char;

import java.util.LinkedList;

public class Solution0921_Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peekFirst() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }
}
