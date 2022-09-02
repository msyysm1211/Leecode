package com.Problem.Q500_Q999;

import java.util.Arrays;

public class Solution0547_Number_of_Provinces {
    int count = 0;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        Arrays.fill(visit, true);
        visit[0] = false;
        count++;
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                visit[i] = false;
                count++;
            }
            dfs(i, visit, isConnected);
        }
        return count;
    }

    void dfs(int start, boolean[] visit, int[][] isConnected) {
        int n = isConnected.length;
        if (start == n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i] && isConnected[start][i] == 1) {
                visit[i] = false;
                dfs(i, visit, isConnected);
            }
        }
    }

    public static void main(String[] args) {
        Solution0547_Number_of_Provinces s = new Solution0547_Number_of_Provinces();
        stringToArray t = new stringToArray();
        int x = s.findCircleNum(t.stringToInt2dArray("[[1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],[0,1,0,1,0,0,0,0,0,0,0,0,0,1,0],[0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],[0,1,0,1,0,0,0,1,0,0,0,1,0,0,0],[0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,1,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,1,0,0,0,1,1,0,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0,0,0],[1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0,0,0],[0,0,0,1,0,0,0,0,0,0,0,1,0,0,0],[0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],[0,1,0,0,0,0,0,0,0,0,0,0,0,1,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]]"));
        System.out.println(x);
    }

}
