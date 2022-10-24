package com.Problem.Q500_Q999;

public class Solution0788_Rotated_Digits {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            String s = String.valueOf(i);
            char[] arrs = s.toCharArray();
            int count = 0;
            boolean flag = false;
            for (char c : arrs) {
                if (c == '2' || c == '5' || c == '6' || c == '9') {
                    count++;
                    flag = true;
                }
                if (c == '0' || c == '1' || c == '8') {
                    count++;
                }
            }
            if (count == arrs.length && flag == true) {
                res++;
            }
        }
        return res;
    }

    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits2(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); ++j) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                ++ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution0788_Rotated_Digits s = new Solution0788_Rotated_Digits();
        System.out.println(s.rotatedDigits(30));
    }

}
