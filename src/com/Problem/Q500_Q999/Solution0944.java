package com.Problem.Q500_Q999;

public class Solution0944 {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int n = strs.length;
        int l = strs[0].length();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < l - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution0944 a = new Solution0944();
        int t = a.minDeletionSize(new String[]{"zyx", "wvu", "tsr"});
        System.out.println(t);
    }
}
