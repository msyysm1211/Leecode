package com.Problem.Q1_Q499;

public class Solution0011 {
    public int maxArea(int[] height) {
        int res = 0;
        int n = height.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int edge1 = 0, edge2 = n - 1;
        while (edge2 > edge1) {
            int cap = Math.min(height[edge1], height[edge2]) * (edge2 - edge1);
            res = Math.max(cap, res);
            if (height[edge2] >= height[edge1]) {
                edge1++;
            } else {
                edge2--;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution0011 a = new Solution0011();
        int t = a.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(t);
    }
}
