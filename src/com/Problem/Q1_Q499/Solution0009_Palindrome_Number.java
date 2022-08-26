package com.Problem.Q1_Q499;

public class Solution0009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversenum = 0;
        while (x > reversenum) {
            reversenum = reversenum * 10 + x % 10;
            x = x / 10;
        }
        return reversenum == x || x == reversenum / 10;
    }

    public static void main(String[] args) {
        Solution0009_Palindrome_Number s = new Solution0009_Palindrome_Number();
        System.out.println(s.isPalindrome(-121));
    }

}
