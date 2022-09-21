package com.Problem.Q500_Q999;

import java.util.Arrays;

public class Solution0698_Partition_to_K_Equal_Sum_Subsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        boolean[] visit = new boolean[n];
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int groupnum = sum / k;
        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, 0, 0, visit, groupnum, k);
    }

    boolean dfs(int[] nums, int index, int sum, int count, boolean[] visit, int groupsum, int k) {
        if (count == k) {
            return true;
        }
        if (sum == groupsum) {
            return dfs(nums, nums.length - 1, 0, count + 1, visit, groupsum, k);
        }
        for (int i = index; i >= 0; i--) {
            if (visit[i] || sum + nums[i] > groupsum) continue;
            visit[i] = true;
            if (dfs(nums, i - 1, sum + nums[i], count, visit, groupsum, k)) {
                return true;
            }
            visit[i] = false;
            if (sum == 0) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0698_Partition_to_K_Equal_Sum_Subsets s = new Solution0698_Partition_to_K_Equal_Sum_Subsets();
        System.out.println(s.canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 4));
    }

}
