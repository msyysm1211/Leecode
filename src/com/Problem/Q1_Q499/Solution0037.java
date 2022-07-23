package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0037 {
    List<Integer> ans = new ArrayList<Integer>();
    List<Integer> path = new ArrayList<Integer>();
    char[][] res = new char[9][9];

    public void solveSudoku(char[][] board) {
        dfs(0, board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    boolean helper(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] box = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = Integer.valueOf(c - '1');
                    row[i][num]++;
                    column[j][num]++;
                    box[i / 3][j / 3][num]++;
                    if (row[i][num] > 1 || column[j][num] > 1 || box[i / 3][j / 3][num] > 1)
                        return false;
                }
            }
        }
        return true;
    }

    void dfs(int start, char[][] board) {
        if (start == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    res[i][j] = board[i][j];
                }
            }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            int x = start / 9;
            int y = start % 9;
            char c = board[x][y];
            if (c != '.') {
                path.add((int) c - '0');
                dfs(start + 1, board);
                break;
            } else {
                char t = (char) (i + '0');
                board[x][y] = t;
                path.add(i);
                if (helper(board)) {
                    dfs(start + 1, board);
                }
                board[x][y] = '.';
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution0037 s = new Solution0037();
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '.', '.', '.', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '.'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        s.solveSudoku(board);
    }
}
