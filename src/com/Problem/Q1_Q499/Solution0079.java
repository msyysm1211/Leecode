package com.Problem.Q1_Q499;

public class Solution0079 {
    int direction[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visit[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (DFS(i, j, 0, board, word, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean DFS(int x, int y, int depth, char[][] board, String word, boolean visit[][]) {
        if (depth == word.length() - 1) {//没有访问过且当前层字符相等
            return visit[x][y] == false && board[x][y] == word.charAt(depth);
        }
        if (board[x][y] == word.charAt(depth)) {
            visit[x][y] = true;
            for (int[] i : direction) {
                int newx = x + i[0];
                int newy = y + i[1];
                if (exceed(newx, newy, board) && !visit[newx][newy]) {
                    boolean flag = DFS(newx, newy, depth + 1, board, word, visit);
                    if (flag) {
                        return true;
                    }
                }
            }
            visit[x][y] = false;
        }
        return false;

    }

    boolean exceed(int x, int y, char[][] board) {//判断是否越界
        int m = board.length;
        int n = board[0].length;
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String args[]) {
        Solution0079 s = new Solution0079();
        boolean res = s.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"
        );
        System.out.println(res);
    }
}
