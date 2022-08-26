package com.Problem.Q1_Q499;

public class Solution0075_Sort_Colors_test2 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution0075_Sort_Colors_test2 s = new Solution0075_Sort_Colors_test2();
        s.sortColors(new int[]{2, 0, 1});
    }

}
