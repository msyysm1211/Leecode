package com.Problem.Q1_Q499;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution0331_Verify_Preorder_Serialization_of_a_Binary_Tree {
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");
        int n = s.length;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s[i].charAt(0);
            stack.push(c);
            while (stack.size() >= 3 && stack.get(0) == '#' && stack.get(1) == '#' && stack.get(2) != '#') {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push('#');
            }
        }
        return stack.size() == 1 && stack.getLast() == '#';
    }

    public static void main(String[] args) {
        Solution0331_Verify_Preorder_Serialization_of_a_Binary_Tree s = new Solution0331_Verify_Preorder_Serialization_of_a_Binary_Tree();
        System.out.println(s.isValidSerialization("9,3,4,#,#,#,1,#,#,2,#,6,#,#"));
    }
}
