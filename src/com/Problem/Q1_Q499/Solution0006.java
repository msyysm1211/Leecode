package com.Problem.Q1_Q499;

public class Solution0006 {
    public String convert(String s, int numRows) {
        int n = s.length();
        int t = numRows * 2 - 2;
        if (numRows == 1 || n == 0 || numRows >= n) {
            return s;
        }
        int c = (n + t - 1) / t * (numRows - 1);
        char map[][] = new char[numRows][c];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            map[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuffer res = new StringBuffer();
        for (char[] row : map) {
            for (char a : row) {
                if (a != 0) {
                    res.append(a);
                }
            }
        }
        return res.toString();
    }

    public static void main(String args[]) {
        Solution0006 a = new Solution0006();
        String s = "ABCDE";
        a.convert(s, 4);
    }
}
