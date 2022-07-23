package com.Problem.Q1_Q499;

import java.util.Stack;

public class Solution0042 {
    public int trap(int[] height) {
        int n = height.length;
        int leftmax[] = new int[n];
        int rightmax[] = new int[n];
        int max = 0;
        leftmax[0] = height[0];
        rightmax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            max += Math.min(rightmax[i], leftmax[i]) - height[i];
        }
        return max;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int max = 0;
        int cur = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (cur < n) {
            while (!stack.empty() && height[cur] > height[stack.peek()]) {
                int num = stack.pop();
                if (stack.empty()) {
                    break;
                }
                max += (Math.min(height[stack.peek()], height[cur]) - height[num]) * (cur - stack.peek() - 1);
            }
            stack.push(cur);
            cur++;
        }
        return max;
    }

    public int trap3(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;
        int max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > lmax) {
                    lmax = height[l];
                } else {
                    max += lmax - height[l];
                }
                l++;
            } else {
                if (height[r] > rmax) {
                    rmax = height[r];
                } else {
                    max += rmax - height[r];
                }
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0042 s = new Solution0042();
        //System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        //System.out.println(s.trap(new int[]{4, 2, 3}));
        // System.out.println(s.trap(new int[]{5, 4, 1, 2}));
        System.out.println(s.trap3(new int[]{9, 6, 8, 8, 5, 6, 3}));
    }
}
