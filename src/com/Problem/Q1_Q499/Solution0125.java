package com.Problem.Q1_Q499;

public class Solution0125 {
    public boolean isPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                buffer.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        StringBuffer reverse = new StringBuffer(buffer).reverse();
        return reverse.toString().equals(buffer.toString());
    }

    public static void main(String args[]) {
        Solution0125 a = new Solution0125();
        System.out.println(a.isPalindrome("OP"));
    }
}
