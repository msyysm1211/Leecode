package com.Problem.Q500_Q999;

import java.util.Stack;

public class Solution0735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                if (stack.peek() < -asteroids[i]) {
                    stack.pop();
                } else if (stack.peek() == -asteroids[i]) {
                    stack.pop();
                    flag = false;
                    break;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                stack.push(asteroids[i]);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0735 s = new Solution0735();
        System.out.println(s.asteroidCollision(new int[]{8, -8}));
    }
}
