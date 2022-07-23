package com.Problem.Q1_Q499;

public class Solution0031 {
    //    public void nextPermutation(int[] nums) {
//        int n = nums.length;
//        int r = n - 1;
//        int l = r - 1;
//        while (l >= 0) {
//            int cur = nums[r];
//            if (nums[l] < nums[r]) {
//                int temp = nums[l];
//                nums[l] = nums[r];
//                nums[r] = temp;
//                break;
//            } else {
//                l--;
//            }
//        }
//        if (l < 0) {
//            reverse(nums);
//        }
//    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int nums[], int start) {
        int n = nums.length;
        int l = start, r = n - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution0031 s = new Solution0031();
        s.nextPermutation(new int[]{1, 3, 2});
    }
}
