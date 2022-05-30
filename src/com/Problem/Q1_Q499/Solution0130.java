package com.Problem.Q1_Q499;

public class Solution0130 {

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            DFS(board, i, 0);
            DFS(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            DFS(board, 0, j);
            DFS(board, n - 1, j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void DFS(char[][] board, int startpoint_x, int startpoint_y) {
        if (startpoint_x < 0 || startpoint_y < 0 || startpoint_x >= board.length || startpoint_y >= board[0].length || board[startpoint_x][startpoint_y] != 'O') {
            return;
        }
        board[startpoint_x][startpoint_y] = 'A';
        DFS(board, startpoint_x + 1, startpoint_y);
        DFS(board, startpoint_x - 1, startpoint_y);
        DFS(board, startpoint_x, startpoint_y + 1);
        DFS(board, startpoint_x, startpoint_y - 1);
    }

    public static void main(String args[]) {
        Solution0130 s = new Solution0130();
        char solve[][] = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'}
        };
        /*char solve[][] = new char[][]{{
                'O', 'O'},
                {
                        'O', 'O'}
        };*/
        s.solve(solve);
    }
}
