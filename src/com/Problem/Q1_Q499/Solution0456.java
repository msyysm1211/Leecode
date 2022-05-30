package com.Problem.Q1_Q499;

import java.util.TreeMap;

class Solution0456 {
    public boolean find132pattern(int[] nums) {//brute force
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    if (nums[i] < nums[j] && nums[j] > nums[k] && nums[k] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {//find max and min when middle move
        int l = nums.length;
        int min = nums[0];
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int k = 2; k < l; k++) {
            map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
        }
        for (int j = 1; j < l - 1; j++) {
            if (nums[j] > min) {
                Integer next = map.ceilingKey(min + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }

            min = Math.min(min, nums[j]);
            map.put(nums[j + 1], map.get(nums[j + 1]) - 1);
            if (map.get(nums[j + 1]) == 0) {
                map.remove(nums[j + 1]);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution0456 a = new Solution0456();
        boolean t = a.find132pattern2(new int[]{3, 1, 4, 2});
    }
}