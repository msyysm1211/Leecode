package com.Problem.Q1_Q499;

public class Solution0067 {
    public String addBinary(String a, String b) {
        boolean pre = false;
        int i = a.length();
        int j = b.length();
        char res[] = new char[Math.max(i, j) + 1];
        while (i < j) {
            a = '0' + a;
            i++;
        }
        while (i > j) {
            b = '0' + b;
            j++;
        }
        while (i >= 1 || j >= 1) {
            if (a.charAt(i - 1) == '1' && b.charAt(i - 1) == '1' && pre == false) {
                pre = true;
                res[i] = '0';
                i--;
                j--;
            } else if (a.charAt(i - 1) == '1' && b.charAt(i - 1) == '1' && pre == true) {
                pre = true;
                res[i] = '1';
                i--;
                j--;
            } else if (a.charAt(i - 1) == '0' && b.charAt(i - 1) == '0' && pre == true) {
                pre = false;
                res[i] = '1';
                i--;
                j--;
            } else if (a.charAt(i - 1) == '0' && b.charAt(i - 1) == '0' && pre == false) {
                pre = false;
                res[i] = '0';
                i--;
                j--;
            } else if (((a.charAt(i - 1) == '0' && b.charAt(i - 1) == '1') || (a.charAt(i - 1) == '1' && b.charAt(i - 1) == '0')) && pre == true) {
                pre = true;
                res[i] = '0';
                i--;
                j--;
            } else if (((a.charAt(i - 1) == '0' && b.charAt(i - 1) == '1') || (a.charAt(i - 1) == '1' && b.charAt(i - 1) == '0')) && pre == false) {
                pre = false;
                res[i] = '1';
                i--;
                j--;
            }
        }
        String ans;
        if (pre == true) {
            res[0] = '1';
            ans = String.valueOf(res);
        } else {
            ans = String.valueOf(res).substring(1, res.length);
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution0067 a = new Solution0067();
        String t = a.addBinary("0", "0");
        System.out.println(t);
    }
}
