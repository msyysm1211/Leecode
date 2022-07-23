package com.Problem.Q1_Q499;

public class Solution0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gassum = 0;
        int costsum = 0;
        int i = 0;
        while (i < n) {
            int cnt = 0;
            gassum = 0;
            costsum = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                gassum += gas[j];
                costsum += cost[j];
                if (gassum < costsum) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = cnt + i + 1;
            }
        }
        return -1;
    }
}
