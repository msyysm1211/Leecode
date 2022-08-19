package com.Problem.Q1_Q499;

public class Solution0075_Sort_Colors {
    public void sortColors(int[] nums) {
        int slow = 0, fast = 0;
        int n = nums.length;
        while (fast < n) {
            while (fast < n && nums[fast] != 0) {
                fast++;
            }
            if (fast < n && nums[fast] == 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
        fast = slow;
        while (fast < n) {
            while (fast < n && nums[fast] != 1) {
                fast++;
            }
            if (fast < n && nums[fast] == 1) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    public void sortColors2(int[] nums) {
        int n = nums.length;
        int cur0 = 0, cur2 = n - 1;
        for (int i = 0; i <= cur2; i++) {
            if (nums[i] == 0) {
                swap(nums, i, cur0);
                cur0++;
            }
            if (nums[i] == 2) {
                swap(nums, i, cur2);
                cur2--;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution0075_Sort_Colors s = new Solution0075_Sort_Colors();
        s.sortColors2(new int[]{1, 2, 0});
    }
}
