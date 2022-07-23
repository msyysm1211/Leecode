package com.Problem.Q1_Q499;

public class Solution0043 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuffer temp = new StringBuffer();
            for (int j = 0; j < num2.length() - i - 1; j++) {
                temp.append('0');
            }
            String muti = helper(num1, num2.charAt(i)) + temp;
            res = add(res, muti);
        }
        return res;
    }

    String helper(String num, char c) {
        int c1 = c - '0';
        StringBuffer buffer = new StringBuffer();
        int flag = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int c2 = i >= 0 ? num.charAt(i) - '0' : 0;
            int sum = flag + c2 * c1;
            flag = (sum) / 10;
            buffer.append(sum % 10);
        }
        if (flag != 0) {
            buffer.append(flag);
        }
        return buffer.reverse().toString();
    }

    String add(String num1, String nums2) {
        int n1 = num1.length() - 1;
        int n2 = nums2.length() - 1;
        StringBuffer buffer = new StringBuffer();
        boolean flag = false;
        while (n1 >= 0 || n2 >= 0 || flag) {
            int c1 = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int c2 = n2 >= 0 ? nums2.charAt(n2) - '0' : 0;
            int sum = flag == true ? c1 + c2 + 1 : c1 + c2;
            flag = sum / 10 == 1;
            buffer.append(sum % 10);
            n1--;
            n2--;
        }
        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        Solution0043 s = new Solution0043();
        s.multiply("9133", "0");
    }
}
