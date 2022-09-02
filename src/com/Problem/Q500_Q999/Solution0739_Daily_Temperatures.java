package com.Problem.Q500_Q999;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution0739_Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= stack.peek()[0]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek()[1] - i;
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0739_Daily_Temperatures s = new Solution0739_Daily_Temperatures();
        s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
