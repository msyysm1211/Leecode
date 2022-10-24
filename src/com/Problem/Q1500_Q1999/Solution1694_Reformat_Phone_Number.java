package com.Problem.Q1500_Q1999;

public class Solution1694_Reformat_Phone_Number {
    public String reformatNumber(String number) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                buffer.append(number.charAt(i));
            }
        }
        int n = buffer.length();
        String numArr = buffer.toString();
        StringBuffer res = new StringBuffer();
        int i = 0;
        while (i < n) {
            if (n - i > 4) {
                res.append(numArr.substring(i, i + 3));
                res.append("-");
                i = i + 3;
            } else {
                if (n - i == 4) {
                    res.append(numArr.substring(i, i + 2));
                    res.append("-");
                    res.append(numArr.substring(i + 2, i + 4));
                    i = n;
                } else {
                    res.append(numArr.substring(i, n));
                    i = n;
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution1694_Reformat_Phone_Number s = new Solution1694_Reformat_Phone_Number();
        System.out.println(s.reformatNumber("123 4-56"));
    }

}
