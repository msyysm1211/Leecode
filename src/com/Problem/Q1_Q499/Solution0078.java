package com.Problem.Q1_Q499;

import com.Problem.Q500_Q999.Solution0784;

import java.util.ArrayList;
import java.util.List;

public class Solution0078 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    void dfs(int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(nums[index]);
        dfs(index + 1, nums);
        path.remove(path.size() - 1);
        dfs(index + 1, nums);
    }

    public static void main(String args[]) {
        Solution0078 s = new Solution0078();
        s.subsets(new int[]{1, 2, 3});
    }
}
