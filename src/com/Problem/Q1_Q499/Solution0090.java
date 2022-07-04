package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0090 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    void dfs(int[] nums, int depth) {
        res.add(new ArrayList<>(path));
        for (int i = depth; i < nums.length; i++) {
            if (i > depth && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String args[]) {
        Solution0090 s = new Solution0090();
        List<List<Integer>> res = s.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println("输出 => " + res);
    }
}
