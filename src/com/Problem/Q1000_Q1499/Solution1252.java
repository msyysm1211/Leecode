package com.Problem.Q1000_Q1499;

public class Solution1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int arr[][] = new int[m][n];
        int a = indices.length;
        for (int i = 0; i < a; i++) {
            for (int y = 0; y < n; y++) {
                arr[indices[i][0]][y] += 1;
            }
            for (int x = 0; x < m; x++) {
                arr[x][indices[i][1]] += 1;
            }
        }
        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt % 2 == 1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1252 s = new Solution1252();
        s.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}});
    }
}
