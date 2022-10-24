package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0289_Game_of_Life {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int live = count(board, i, j, 1) - 1;
                    if (live == 2 || live == 3) {
                        res[i][j] = 1;
                    } else {
                        res[i][j] = 0;
                    }
                } else {
                    int life = count(board, i, j, 1);
                    if (life == 3) {
                        res[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    int count(int[][] board, int x, int y, int find) {
        int[] xmove = {-1, 0, 1};
        int[] ymove = {-1, 0, 1};
        int count = 0;
        for (int i : xmove) {
            for (int j : ymove) {
                int newx = x + i;
                int newy = y + j;
                if (newx >= 0 && newx <= board.length - 1 && newy >= 0 && newy <= board[0].length - 1) {
                    if (find == 1 && board[newx][newy] == 1) {
                        count++;
                    }
                    if (find == 0 && board[newx][newy] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution0289_Game_of_Life s = new Solution0289_Game_of_Life();
        stringToArray t = new stringToArray();
        s.gameOfLife(t.stringToInt2dArray("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]"));
    }

}
