package com.Problem.Q500_Q999;

import com.Problem.Q1_Q499.Solution0473;

import java.util.Arrays;

public class Solution0698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int groupsum = Arrays.stream(nums).sum() / k;
        if (Arrays.stream(nums).sum() % k != 0) {
            return false;
        }
        int n = nums.length;
        int state[] = new int[1 << n];
        Arrays.fill(state, -1);
        state[0] = 0;
        for (int i = 1; i < state.length; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                int prevState = i & ~(1 << j);
                if (state[prevState] >= 0 && state[prevState] + nums[j] <= groupsum) {
                    state[i] = (state[prevState] + nums[j]) % groupsum;
                    break;
                }
            }
        }
        return state[(1 << n) - 1] == 0;
    }


    public static void main(String[] args) {
        Solution0698 s = new Solution0698();
        System.out.println(s.canPartitionKSubsets(new int[]{1, 2, 3}, 3));
    }
}
