package com.Problem.Q1_Q499;

import java.util.*;

class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        //StringBuffer buffer = new StringBuffer();
        char minchar = s.charAt(n - 1);
        int minindex = n - 1;
        int[] index = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) > minchar) {
                index[i] = minindex;
            } else {
                index[i] = -1;
                minindex = i;
                minchar = s.charAt(i);
            }
        }
        if (minchar == s.charAt((n - 1))) {
            index[n - 1] = -1;
        } else {
            index[n - 1] = 100;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (index[i] == -1) {
                buffer.append(s.charAt(i));
            } else {
                if (!stack.isEmpty() && index[stack.peek()] > index[i]) {
                    buffer.append(s.charAt(i));
                }
                while (!stack.isEmpty() && index[stack.peek()] > index[i]) {
                    int curindex = stack.pop();
                    buffer.append(s.charAt(curindex));
                }
                stack.push(i);
            }
        }
        StringBuffer temp = new StringBuffer();
        while (!stack.isEmpty()) {
            temp.append(s.charAt(stack.pop()));
        }
        buffer.append(temp.reverse().toString());
        return buffer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        stringToArray t = new stringToArray();
        System.out.println(s.robotWithString("bydizfve"));
        System.out.println(s.robotWithString("bdda"));
    }

}