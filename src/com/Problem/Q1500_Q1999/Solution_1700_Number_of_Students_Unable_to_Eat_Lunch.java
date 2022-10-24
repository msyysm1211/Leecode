package com.Problem.Q1500_Q1999;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution_1700_Number_of_Students_Unable_to_Eat_Lunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            if (students[i] == 1)
                cnt[1]++;
            else cnt[0]++;
        }
        for (int i = 0; i < n; i++) {
            int top = sandwiches[i];
            if (cnt[top] > 0) {
                cnt[top]--;
            } else break;
        }
        return cnt[0] + cnt[1];
    }
}
