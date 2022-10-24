package com.Problem.Q500_Q999;

public class Solution0777_Swap_Adjacent_in_LR_String {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                if (start.charAt(i) == 'L' && i < j) {
                    return false;
                }
                if (start.charAt(i) == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0777_Swap_Adjacent_in_LR_String s = new Solution0777_Swap_Adjacent_in_LR_String();
        System.out.println(s.canTransform("XL",
                "LX"));
    }

}
