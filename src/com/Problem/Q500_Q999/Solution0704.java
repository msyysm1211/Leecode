package com.Problem.Q500_Q999;

public class Solution0704 {
    public int search(int[] nums, int target) {
        int res = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution0704 a = new Solution0704();
        int t = a.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        System.out.println(t);
    }
}
