package com.Problem.Q1_Q499;

public class Solution0167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l + 1, r + 1};
    }

}
