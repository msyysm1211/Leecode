package com.Problem.Q500_Q999;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution0907_Sum_of_Subarray_Minimums {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int[] l = new int[n];
        int[] r = new int[n];
        int ans = 0;
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.getLast()] >= arr[i]) {
                r[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.getLast()] > arr[i]) {
                l[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            int a = l[i], b = r[i];
            ans += (i - a) * 1L * (b - i) % mod * arr[i] % mod;
            ans %= mod;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution0907_Sum_of_Subarray_Minimums s = new Solution0907_Sum_of_Subarray_Minimums();
        int t = s.sumSubarrayMins(new int[]{11, 81, 94, 43, 3});
        System.out.println(t);
    }
}
