package com.Problem.Q1_Q499;

public class Solution0012 {
    public String intToRoman(int num) {
        String arr[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int value[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            while (value[i] <= num) {
                res.append(arr[i]);
                num -= value[i];
            }
            if (num == 0) {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String args[]) {
        Solution0012 a = new Solution0012();
        System.out.println(a.intToRoman(3));
    }
}
