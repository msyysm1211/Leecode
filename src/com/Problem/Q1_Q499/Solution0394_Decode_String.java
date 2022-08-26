package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Solution0394_Decode_String {
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        StringBuffer res = new StringBuffer();
        int n = s.length();
        int pos = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            set.add(String.valueOf(i));
        }
        while (pos < n) {
            while (pos < n && s.charAt(pos) != ']') {
                stack.push(String.valueOf(s.charAt(pos)));
                pos++;
            }
            if (pos < n) {
                StringBuffer substring = new StringBuffer();
                while (!stack.isEmpty() && !stack.peekFirst().equals("[")) {
                    substring.append(stack.pop());
                }
                String subs = substring.reverse().toString();
                StringBuffer digit = new StringBuffer();
                if (!stack.isEmpty()) {
                    stack.poll();
                    while (!stack.isEmpty() && set.contains(stack.peekFirst())) {
                        digit.append(stack.pop());
                    }
                    int num = Integer.valueOf(digit.reverse().toString());
                    String newstring = subs.repeat(num);
                    stack.push(newstring);
                }
                pos++;
            }
        }
        int size = stack.size();
        for (int i = size - 1; i >= 0; i--) {
            res.append(stack.get(i));
        }
        return res.toString();
    }

    public String decodeString2(String s) {
        StringBuffer res = new StringBuffer();
        LinkedList<Integer> muti = new LinkedList<>();
        LinkedList<String> substring = new LinkedList<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                muti.add(multi);
                substring.add(res.toString());
                multi = 0;
                res = new StringBuffer();
            } else if (c == ']') {
                //substring.removeLast();
                String temp = res.toString().repeat(muti.removeLast());
                res = new StringBuffer(substring.removeLast() + temp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Solution0394_Decode_String s = new Solution0394_Decode_String();
        System.out.println(s.decodeString2("3[a2[c]]"));
    }

}
