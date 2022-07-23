package com.Problem.Q1_Q499;

public class Solution0494 {
    int res;

    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        dfs(0, target, nums);
        return res;
    }

    void dfs(int start, int target, int[] nums) {
        int n = nums.length;
        if (start == n) {
            if (target == 0) {
                res++;
            }
        } else {
            dfs(start + 1, target - nums[start], nums);
            dfs(start + 1, target + nums[start], nums);
        }
    }

    public static void main(String[] args) {
        Solution0494 s = new Solution0494();
        int t = s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(t);
    }
}
