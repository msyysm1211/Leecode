package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = nums.length - 1; j > 2; j--) {
                if (j < nums.length - 1 && nums[j + 1] == nums[j]) {
                    continue;
                }
                int l = i + 1, r = j - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r] + nums[j];
                    if (sum == target) {
                        while (nums[l + 1] == nums[l] && l < r) {
                            l++;
                        }
                        while (nums[r - 1] == nums[r] && l < r) {
                            r--;
                        }
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        list.add(nums[j]);
                        res.add(new ArrayList<Integer>(list));
                        l++;
                        r--;
                    }
                    if (sum < target) {
                        l++;
                    }
                    if (sum > target) {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution18 a = new Solution18();
        List<List<Integer>> res = a.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        System.out.println(res);
    }
}
