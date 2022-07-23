package com.Problem.Q1_Q499;

public class Solution0036 {
    public boolean isValidSudoku(char[][] board) {
        int row[][] = new int[9][9];
        int columns[][] = new int[9][9];
        int group[][][] = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = Integer.valueOf(c - 'a');
                    row[i][c]++;
                    columns[j][c]++;
                    group[i / 3][j / 3][c]++;
                    if (row[i][c] > 1 || columns[j][c] > 1 || group[i / 3][j / 3][c] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
