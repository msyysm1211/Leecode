package com.Problem.Q1000_Q1499;

public class Solution1464_Maximum_Product_of_Two_Elements_in_an_Array {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = 0, smaller = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > smaller) {
                if (nums[i] > max) {
                    smaller = max;
                    max = nums[i];
                } else {
                    smaller = nums[i];
                }
            }
        }
        return (max - 1) * (smaller - 1);
    }
}
